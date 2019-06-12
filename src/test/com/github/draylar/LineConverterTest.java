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
        assertEquals("import net.minecraft.client.model.Cuboid;", CONVERTER.convertLine("import net.minecraft.client.model.ModelBox;"));
        assertEquals("import net.minecraft.client.render.entity.model.EntityModel;", CONVERTER.convertLine("import net.minecraft.client.model.ModelBase;"));
        assertEquals("", CONVERTER.convertLine("import org.lwjgl.opengl.GL11;"));
        assertEquals("private final Cuboid bone;", CONVERTER.convertLine("private final ModelRenderer bone;"));
        assertEquals("public class name extends EntityModel<YourEntity> {", CONVERTER.convertLine("public class name extends ModelBase {"));
        assertEquals("body.addBox(-3.0F, 4.0F, -2.0F, 6, 10, 3, 0, 16, 0.0F);", CONVERTER.convertLine("body.cubeList.add(new ModelBox(body, 0, 16, -3.0F, 4.0F, -2.0F, 6, 10, 3, 0.0F, false));"));
        assertEquals("public void render(YourEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {", CONVERTER.convertLine("public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {"));
    }
}
