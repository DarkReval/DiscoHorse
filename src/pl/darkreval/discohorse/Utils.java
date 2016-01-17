package pl.darkreval.discohorse;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Horse.Color;
import org.bukkit.entity.Horse.Style;
import org.bukkit.inventory.ItemStack;

public class Utils {
	
	public static List<Horse> horseList = new ArrayList<Horse>();
	public static Random randomGenerator;
	
	public static Color randColor() {
		List<Color> colors = new ArrayList<Color>();
		colors.add(Color.BLACK);
		colors.add(Color.BROWN);
		colors.add(Color.CHESTNUT);
		colors.add(Color.CREAMY);
		colors.add(Color.DARK_BROWN);
		colors.add(Color.GRAY);
		colors.add(Color.WHITE);
		Color r = colors.get(randInt(colors.size()));
		return r;
	}
	
	public static Style randStyle() {
		List<Style> styles = new ArrayList<Style>();
		styles.add(Style.BLACK_DOTS);
		styles.add(Style.NONE);
		styles.add(Style.WHITE);
		styles.add(Style.WHITE_DOTS);
		styles.add(Style.WHITEFIELD);
		Style s = styles.get(randInt(styles.size()));
		return s;
	}
	
	public static ItemStack randArmor() {
			List<ItemStack> armors = new ArrayList<ItemStack>();
			armors.add(new ItemStack(Material.DIAMOND_BARDING));
			armors.add(new ItemStack(Material.GOLD_BARDING));
			armors.add(new ItemStack(Material.IRON_BARDING));
			ItemStack a = armors.get(randInt(armors.size()));
			return a;
	}
	
	public static int randInt(int size) {
		randomGenerator = new Random();;
		int index = randomGenerator.nextInt(size);
	    return index;
	}
	
	public static boolean randBool() {
		return randomGenerator.nextBoolean();
	}

}
