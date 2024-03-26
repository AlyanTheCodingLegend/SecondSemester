import javax.swing.JOptionPane;

// Class representing an ingredient
class Ingredient {
    private String name;
    private int quantity;
    private String unit;

    // Constructor to initialize an ingredient
    public Ingredient(String name, int quantity, String unit) {
        this.name = name;
        this.quantity=quantity;
        this.unit=unit;
    }

    // Getter method for name
    public String getName() {
        return name;
    }

    // Getter method for quantity
    public int getQuantity() {
        return quantity;
    }

    // Getter method for unit
    public String getUnit() {
        return unit;
    }
}

// Class representing a recipe
class Recipe {
    private String recipeName;
    private Ingredient[] ingredients;
    private String[] cookingInstructions;

    // Constructor to initialize a recipe
    public Recipe(String name) {
        this.recipeName = name;
        this.ingredients = new Ingredient[10]; // Initialize array to hold ingredients
        this.cookingInstructions = new String[15]; // Initialize array to hold cooking instructions
    }

    // Method to add an ingredient to the recipe
    public void addIngredient(String ingredientName, int ingredientQuantity, String ingredientUnit) {
        for (int i = 0; i < ingredients.length; i++) {
            if (ingredients[i] == null) {
                ingredients[i] = new Ingredient(ingredientName, ingredientQuantity, ingredientUnit);
                return; // Exit the loop once ingredient is added
            }
        }
        JOptionPane.showMessageDialog(null, "Maximum ingredients reached for this recipe.");
    }

    // Method to add a cooking instruction to the recipe
    public void addCookingInstruction(String instruction) {
        for (int i = 0; i < cookingInstructions.length; i++) {
            if (cookingInstructions[i] == null) {
                cookingInstructions[i] = instruction;
                return; // Exit the loop once instruction is added
            }
        }
        JOptionPane.showMessageDialog(null, "Maximum instructions reached for this recipe.");
    }

    // Method to display recipe details
    public void displayRecipeDetails() {
        String details = "";
        details+="Recipe Name: "+recipeName+"\n";
        details+="Ingredients:\n";
        for (Ingredient ingredient : ingredients) {
            if (ingredient != null) {
                details+="- " + ingredient.getName() + " " + ingredient.getQuantity() + " " + ingredient.getUnit() + "\n";
            };
        }
        details+="Cooking Instructions:\n";
        for (int i = 0; i < cookingInstructions.length; i++) {
            if (cookingInstructions[i] != null) {
                details+=(i + 1)+". "+cookingInstructions[i]+"\n";
            }    
        }
        // Show recipe details in a message dialog
        JOptionPane.showMessageDialog(null, details.toString());
    }
}

// Main class for Recipe Management System
public class RecipeManagementSystem {
    public static void main(String[] args) {
        Recipe[] recipes = new Recipe[20]; // Assuming maximum number of recipes are 20
        int recipeCount = 0; // Counter for the number of recipes

        while (true) {
            // Display menu options
            String option = JOptionPane.showInputDialog("Menu:\n"
                    + "1. Create a new recipe.\n"
                    + "2. Add ingredients to a recipe.\n"
                    + "3. Add cooking instructions to a recipe.\n"
                    + "4. Display recipe details.\n"
                    + "5. Exit the program.\n"
                    + "Enter your choice:");

            // Switch based on user's choice
            switch (option) {
                case "1":
                    if (recipeCount < recipes.length) {
                        String recipeName = JOptionPane.showInputDialog("Enter recipe name:");
                        recipes[recipeCount] = new Recipe(recipeName);
                        recipeCount++;
                    } else {
                        JOptionPane.showMessageDialog(null, "Maximum recipes reached.");
                    }
                    break;
                case "2":
                    int recipeIndex1 = Integer.parseInt(JOptionPane.showInputDialog("Enter recipe index:")) - 1;
                    if (recipeIndex1 >= 0 && recipeIndex1 < recipeCount) {
                        String ingredientName = JOptionPane.showInputDialog("Enter ingredient name:");
                        String ingredientQuantity = JOptionPane.showInputDialog("Enter ingredient quantity:");
                        String ingredientUnit = JOptionPane.showInputDialog("Enter ingredient unit:");
                        recipes[recipeIndex1].addIngredient(ingredientName, Integer.parseInt(ingredientQuantity), ingredientUnit);
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid recipe index.");
                    }
                    break;
                case "3":
                    int recipeIndex2 = Integer.parseInt(JOptionPane.showInputDialog("Enter recipe index:")) - 1;
                    if (recipeIndex2 >= 0 && recipeIndex2 < recipeCount) {
                        String instruction = JOptionPane.showInputDialog("Enter cooking instruction:");
                        recipes[recipeIndex2].addCookingInstruction(instruction);
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid recipe index.");
                    }
                    break;
                case "4":
                    int recipeIndex3 = Integer.parseInt(JOptionPane.showInputDialog("Enter recipe index:")) - 1;
                    if (recipeIndex3 >= 0 && recipeIndex3 < recipeCount) {
                        recipes[recipeIndex3].displayRecipeDetails();
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid recipe index.");
                    }
                    break;
                case "5":
                    System.exit(0);
                    break;
                default:
                    // Show message for invalid option
                    JOptionPane.showMessageDialog(null, "Invalid option. Please choose again.");
            }
        }
    }
}
