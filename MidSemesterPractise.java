import javax.swing.JOptionPane;

interface Weapon {
    void shoot();
}

abstract class Part {
    protected int modelNumber;

    public Part(int modelNumber) {
        this.modelNumber = modelNumber;
    }

    public int getModelNumber() {
        return modelNumber;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [modelNumber=" + modelNumber + "]";
    }
}

class Arm extends Part implements Weapon {
    public double strength;

    public Arm(int modelNumber, double strength) {
        super(modelNumber);
        this.strength = strength;
    }

    @Override
    public void shoot() {
        System.out.println("ZRRRRRRR");
    }
}

class Robot {
    private String name;
    private Arm leftArm;
    private Arm rightArm;

    public Robot(String name, Arm leftArm, Arm rightArm) {
        this.name = name;
        this.leftArm = leftArm;
        this.rightArm = rightArm;
    }

    public void shootLaser() {
        System.out.printf("Shooting laser.........\nLeft Arm Model: %d\nLeft Arm Strength: %f\nRight Arm Model: %d\nRight Arm Strength: %f\n",leftArm.getModelNumber(),leftArm.strength,rightArm.getModelNumber(),rightArm.strength);
    }

    public void introduce() {
        System.out.printf("Hi, I am %s and my purpose is to defeat all other robots.\n", this.name);
    }
}

public class MidSemesterPractise {
    public static void main(String args[]) {
        int leftModel = Integer.parseInt(JOptionPane.showInputDialog("Please enter model of left arm:"));
        double leftStrength = Double.parseDouble(JOptionPane.showInputDialog("Please enter strength of left arm:"));
        int rightModel = Integer.parseInt(JOptionPane.showInputDialog("Please enter model of right arm:"));
        double rightStrength = Double.parseDouble(JOptionPane.showInputDialog("Please enter strength of right arm:"));

        Arm leftArm = new Arm(leftModel, leftStrength);
        Arm rightArm = new Arm(rightModel, rightStrength);

        Robot robot1 = new Robot("Lancelot", leftArm, rightArm);
        robot1.shootLaser();
        robot1.introduce();
    }
}