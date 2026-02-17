package nadiendev.ultimateangelring.compatibilidad.jei;

import nadiendev.ultimateangelring.UltimateAngelRings;
import nadiendev.ultimateangelring.items.ItemsDelMod;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

@JeiPlugin
public class JEICompat implements IModPlugin {

    @Override
    public ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(UltimateAngelRings.MOD_ID, "jei_plugin");
    }
     
    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        // Angel Ring
        registration.addIngredientInfo(
                new ItemStack(ItemsDelMod.ANGEL_RING.get()),
                VanillaTypes.ITEM_STACK,
                Component.translatable("jei.ultimateangelring.angel_ring.info")
        );
    }
}