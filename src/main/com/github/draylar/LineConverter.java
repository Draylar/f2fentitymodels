package main.com.github.draylar;

public class LineConverter {
    // bone.cubeList.add(new ModelBox(bone, 0, 0, -4.0F, -47.0F, -9.0F, 8, 27, 18, 0.0F, false));
    // bone.addBox( -4.0F, -27, -9, 8, 27, 18);

    /**
     * Convert the lines from a 1.12 Forge model class to a 1.14 Fabric model class with appropriate mapping changes.
     *
     * @param string line to be converted
     * @return converted line
     */
    public String convertLine(String string) {
        if (string.contains("Paste this code")) {
            return "";
        }

        if (string.contains("import")) {
            if (string.contains("net.minecraft.client.model.ModelBox")) {
                return "import net.minecraft.client.model.Cuboid;";
            }

            if (string.contains("net.minecraft.client.model.ModelBase")) {
                return "import net.minecraft.client.render.entity.model.EntityModel;";
            }

            return "";
        }

        if (string.contains("ModelRenderer")) {
            return string.replace("ModelRenderer", "Cuboid");
        }

        if (string.contains("ModelBase")) {
            return string.replace("ModelBase", "EntityModel<YourEntity>");
        }

        if (string.contains(".cubeList.add(new ModelBox(")) {
            string = string.replace("        ", "");

            // start: body.cubeList.add(new ModelBox(body, 0, 16, -3.0F, 4.0F, -2.0F, 6, 10, 3, 0.0F, false));
            String[] split = string.split(" ");
            for (int i = 0; i < split.length; i++) {
                split[i] = split[i].replace(",", "");
            }

            String name = split[0].substring(0, split[0].indexOf("."));
            int texX = Integer.parseInt(split[2]);
            int texY = Integer.parseInt(split[3]);
            float x = Float.parseFloat(split[4]);
            float y = Float.parseFloat(split[5]);
            float z = Float.parseFloat(split[6]);
            int x1 = Integer.parseInt(split[7]);
            int y1 = Integer.parseInt(split[8]);
            int z1 = Integer.parseInt(split[9]);
            float unknown = Float.parseFloat(split[10]);

            return name + ".addBox(" + "\"" + name + "\"" + ", " + +x + "F" + ", " + y + "F" + ", " + z + "F" + ", " + x1 + ", " + y1 + ", " + z1 + ", " + unknown + "F" + ", " + texX + ", " + texY + ");";
        }

        if (string.contains("public void render")) {
            return string.replace("Entity", "YourEntity");
        }

        if (string.contains("rotateAngleX = x;")) {
            return "        modelRenderer.pitch = x;";
        }

        if (string.contains("rotateAngleY = y;")) {
            return "        modelRenderer.yaw = y;";
        }

        if (string.contains("rotateAngleZ = z;")) {
            return "        modelRenderer.roll = z;";
        }

        return string;
    }
}
