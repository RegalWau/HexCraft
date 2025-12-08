package celestek.hexcraft.client.model.special;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Function;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ForgeBlockStateV1;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.common.model.IModelState;
import net.minecraftforge.common.model.TRSRTransformation;

public class ModelMonolith implements IModel
{
	protected final ResourceLocation base, monolith;
	/**
	 * The matrix transform with the parsed rotation tags
	 */
	protected final Optional<TRSRTransformation> transform;

	public ModelMonolith(ResourceLocation base, ResourceLocation monolith, Optional<TRSRTransformation> transform)
	{
		this.base = base;
		this.monolith = monolith;
		this.transform = transform;
	}

	// FIXME Return missing model if not enough textures are specified
	@Override
	public IBakedModel bake(IModelState state, VertexFormat format, Function<ResourceLocation, TextureAtlasSprite> getter)
	{
		// Convert all the texture paths to sprites and pass them and the matrix and perspective transforms to the baked model
		return new BakedModelMonolith(state, format, this.transform, getter.apply(this.base), getter.apply(this.monolith));
	}

	@Override
	public Collection<ResourceLocation> getTextures()
	{
		// Return all the saved texture paths as dependencies
		ImmutableSet.Builder builder = ImmutableSet.builder();
		if(this.base != null) builder.add(this.base);
		if(this.monolith != null) builder.add(this.monolith);
		return builder.build();
	}

	public static final String TAG_ROTATION_X = "rotation_x", TAG_ROTATION_Y = "rotation_y", TAG_ROTATION_Z = "rotation_z";

	@Override
	public IModel process(ImmutableMap<String, String> data)
	{
		// Parse each rotation tag if present
		float rotationX = data.containsKey(TAG_ROTATION_X) ? Float.parseFloat(data.get(TAG_ROTATION_X)) : 0f;
		float rotationY = data.containsKey(TAG_ROTATION_Y) ? Float.parseFloat(data.get(TAG_ROTATION_Y)) : 0f;
		float rotationZ = data.containsKey(TAG_ROTATION_Z) ? Float.parseFloat(data.get(TAG_ROTATION_Z)) : 0f;
		// Convert rotations to a matrix transform if any are present
		return rotationX != 0f || rotationY != 0f || rotationZ != 0f ? new ModelMonolith(this.base, this.monolith, Optional.of(ForgeBlockStateV1.Transforms.convert(0f, 0f, 0f, rotationX, rotationY, rotationZ, 1f))) : this;
	}

	public static final String TEXTURE_BASE = "base", TEXTURE_MONOLITH = "monolith";

	@Override
	public IModel retexture(ImmutableMap<String, String> textures)
	{
		// Save all the texture paths
		return new ModelMonolith(new ResourceLocation(textures.get(TEXTURE_BASE)), new ResourceLocation(textures.get(TEXTURE_MONOLITH)), this.transform);
	}
}