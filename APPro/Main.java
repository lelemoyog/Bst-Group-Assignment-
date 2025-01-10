import javax.swing.*;

public class Main extends JFrame {
    public static void main(String[] args) {
        JTextArea displayArea=new JTextArea();
        // Create an instance of the BinarySearchTree
        BinarySearchTree bst = new BinarySearchTree();
        Word[] dictionary = {
                new Word("Apple", "A round fruit of a tree of the rose family."),
                new Word("Ant", "A small insect that lives in a colony."),
                new Word("Apex", "The top or highest part of something."),
                new Word("Ball", "A spherical object used in games or sports."),
                new Word("Bark", "The outer covering of a tree."),
                new Word("Brave", "Showing courage."),
                new Word("Cat", "A small domesticated carnivorous mammal."),
                new Word("Cup", "A small container for drinking liquids."),
                new Word("Calm", "Peaceful, without strong emotions."),
                new Word("Dog", "A domesticated carnivorous mammal often kept as a pet."),
                new Word("Dot", "A small round mark or spot."),
                new Word("Dusk", "The time just before nightfall."),
                new Word("Eagle", "A large bird of prey with a massive hooked bill."),
                new Word("Earn", "To receive money for work or services."),
                new Word("Earth", "The planet on which we live."),
                new Word("Fan", "A device for creating a current of air."),
                new Word("Fast", "Moving at high speed."),
                new Word("Fate", "The development of events beyond control."),
                new Word("Game", "An activity one engages in for amusement or competition."),
                new Word("Glow", "To shine with a soft light."),
                new Word("Goal", "The object of a person's ambition or effort."),
                new Word("Hat", "A covering for the head, often worn for warmth or fashion."),
                new Word("Hope", "A feeling of expectation and desire for a certain thing to happen."),
                new Word("Huge", "Extremely large in size or amount."),
                new Word("Ice", "Frozen water."),
                new Word("Idea", "A thought or suggestion as to a possible course of action."),
                new Word("Idle", "Avoiding work; lazy or inactive."),
                new Word("Jam", "A sweet spread made from fruit and sugar."),
                new Word("Jump", "To push oneself off the ground using the legs."),
                new Word("Just", "Based on or behaving according to what is morally right."),
                new Word("Kite", "A lightweight frame covered with fabric, flown in the wind."),
                new Word("King", "The male ruler of an independent state."),
                new Word("Kind", "Having a friendly, generous, or considerate nature."),
                new Word("Lamp", "A device for giving light."),
                new Word("Land", "The part of the Earth's surface not covered by water."),
                new Word("Luck", "Success or failure brought by chance rather than through one’s actions."),
                new Word("Man", "An adult human male."),
                new Word("Map", "A diagrammatic representation of an area of land or sea."),
                new Word("Moon", "The natural satellite of the Earth."),
                new Word("Nest", "A structure built by birds for laying eggs."),
                new Word("New", "Not existing before; recently made."),
                new Word("Nice", "Pleasant, kind, or polite."),
                new Word("Oak", "A tree known for its strong wood."),
                new Word("Open", "Allowing access, passage, or view."),
                new Word("Orb", "A spherical object or shape."),
                new Word("Pen", "An instrument for writing or drawing with ink."),
                new Word("Pick", "To select from a group."),
                new Word("Pure", "Not mixed or adulterated with any other substance."),
                new Word("Queen", "The female ruler of an independent state."),
                new Word("Quiet", "Making little or no noise."),
                new Word("Quick", "Moving fast or doing something in a short time."),
                new Word("Rat", "A rodent similar to but larger than a mouse."),
                new Word("Rich", "Having a great deal of money or assets."),
                new Word("Ripe", "Fully grown and ready to eat (of fruit or grain)."),
                new Word("Sand", "A loose granular substance found on beaches."),
                new Word("Safe", "Protected from harm or danger."),
                new Word("Soft", "Having a smooth surface or texture."),
                new Word("Tree", "A woody perennial plant with branches."),
                new Word("Tall", "Of great height."),
                new Word("Task", "A piece of work to be done."),
                new Word("Umbrella", "A device for protection against rain or sunlight."),
                new Word("Unite", "To come or bring together."),
                new Word("Usual", "Habitually done or occurring."),
                new Word("Van", "A vehicle used for transporting goods or people."),
                new Word("Vast", "Extremely large in area, size, or amount."),
                new Word("Visit", "To go and spend time in a place or with someone."),
                new Word("Water", "A transparent, odorless liquid."),
                new Word("Warm", "Having a moderate degree of heat."),
                new Word("Wise", "Having experience, knowledge, and good judgment."),
                new Word("X-ray", "A form of electromagnetic radiation."),
                new Word("Xenon", "A chemical element, a noble gas."),
                new Word("Xylophone", "A musical instrument with wooden bars."),
                new Word("Yarn", "Thread used for knitting or weaving."),
                new Word("Yell", "To shout loudly."),
                new Word("Yearn", "To have an intense longing for something."),
                new Word("Zebra", "A wild animal with black-and-white stripes."),
                new Word("Zoom", "To move quickly or rapidly."),
                new Word("Zen", "A form of Buddhism focusing on meditation and intuition.")
        };
        for (Word word : dictionary) {
            bst.insert(word.getWord(), word.getMeaning());
            displayArea.setText(word.getWord() + " " + word.getMeaning());
        }


        // Load the dictionary from the file (if available)
        try {
            bst.loadFromFile("dictionary.txt");
        } catch (Exception e) {
            System.out.println("No existing dictionary found, starting with an empty dictionary.");
        }

        // Launch the GUI for the dictionary application
        new DictionaryGUI(bst);
    }


}
