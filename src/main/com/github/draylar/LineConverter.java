package main.com.github.draylar;

public class LineConverter
{
    /**
     * Convert the lines from a 1.12 Forge model class to a 1.14 Fabric model class with appropriate mapping changes.
     * @param string line to be converted
     * @return converted line
     */
    public String convertLine(String string)
    {
        if(string.contains("Paste this code"))
        {
            return "";
        }

        if (string.contains("import"))
        {
            if(string.contains("net.minecraft.client.model.ModelBox"))
            {
                return "import net.minecraft.client.model.Cuboid;";
            }

            if(string.contains("net.minecraft.client.model.ModelBase"))
            {
                return "import net.minecraft.client.render.entity.model.EntityModel;";
            }

            return "";
        }

        if (string.contains("ModelRenderer"))
        {
            return string.replace("ModelRenderer", "Cuboid");
        }

        if (string.contains("ModelBase"))
        {
            return string.replace("ModelBase", "EntityModel<YourEntity>");
        }

        if (string.contains(".cubeList.add(new ModelBox("))
        {
            string = string.replaceAll("cubeList.add\\(new ModelBox\\(([^\\s]+), ([^\\s]+), ([^\\s]+) ", "addBox(");
            string = string.replaceAll(", ([^\\s]+) ([^\\s]+)\\)\\);", ");");
            return string;
        }

        if (string.contains("public void render"))
        {
            return string.replace("Entity", "YourEntity");
        }

        if(string.contains("rotateAngleX = x;"))
        {
            return "        modelRenderer.rotationPointX = x;";
        }

        if(string.contains("rotateAngleY = y;"))
        {
            return "        modelRenderer.rotationPointY = y;";
        }

        if(string.contains("rotateAngleZ = z;"))
        {
            return "        modelRenderer.rotationPointZ = z;";
        }

        return string;
    }
}
