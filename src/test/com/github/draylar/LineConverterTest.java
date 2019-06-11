package test.com.github.draylar;

import main.com.github.draylar.LineConverter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LineConverterTest
{
    private final LineConverter CONVERTER = new LineConverter();

    @Test
    void testLineConversions()
    {
        assertEquals("import net.minecraft.client.model.Cuboid;", CONVERTER.convertLine("import net.minecrat.client.model.ModelBox;"));
        assertEquals("import net.minecraft.client.render.entity.model.EntityModel;", CONVERTER.convertLine("import net.minecraft.client.model.ModelBase;"));
        assertEquals("", CONVERTER.convertLine("import org.lwjgl.opengl.GL11;"));
        assertEquals("private final Cuboid bone;", CONVERTER.convertLine("private final ModelRenderer bone;"));
        assertEquals("public class name extends EntityModel<YourEntity> {", CONVERTER.convertLine("public class name extends ModelBase {"));
        assertEquals("bone.addBox(-1F, -1F, -1F, 2F, 2F, 2F);", CONVERTER.convertLine("bone.cubeList.add(new ModelBox(bone, 0, 0, -1F, -1F, -1F, 2F, 2F, 2F, 0, false));"));
        assertEquals("public void render(YourEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {", CONVERTER.convertLine("public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {"));
    }
}
