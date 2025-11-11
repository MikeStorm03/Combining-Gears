import os
import json

path = "D:/Minecraft/Stuffs/projects/Combining Gears/mod/common/src/main/resources/assets/minecraft/lang"
key_need = ["item.minecraft.copper_sword",
            "item.minecraft.copper_axe",
            "item.minecraft.copper_pickaxe",
            "item.minecraft.copper_shovel",
            "item.minecraft.copper_hoe",
            "item.minecraft.copper_helmet",
            "item.minecraft.copper_chestplate",
            "item.minecraft.copper_leggings",
            "item.minecraft.copper_boots",
            "item.minecraft.copper_horse_armor",
            "item.minecraft.netherite_horse_armor"
            ]

for i in os.listdir(path):
    if i.endswith('.json'):
        file_path = os.path.join(path, i)
        try:
            with open(file_path, 'r', encoding='utf-8') as f:
                data = json.load(f)
            filtered_data = {j: data[j] for j in key_need if j in data}
            with open(file_path, 'w', encoding='utf-8') as f:
                json.dump(filtered_data, f, ensure_ascii=False, indent=2)
        except Exception as e:
            print(f"Error file {i}: {e}")
