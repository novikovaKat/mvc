/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc;

import character.Stats;
import character.Character;
import dndClass.CharacterClass;
import dndClass.ClassFactory;
import dndClass.Druid;
import dndClass.Fighter;
import dndRace.CharacterRace;
import dndRace.Dragonborn;
import dndRace.DragonbornFactory;
import dndRace.Human;
import dndRace.HumanFactory;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import memento.Originator;
import visitor.DataElement;

/**
 *
 * @author 0802n
 */
public class Controller {
    private static Model model = new Model();    

    public static void generateStats() {
        Originator originator = model.getOriginator();
        originator.generateNew();
        HashMap <String, Integer> stats = originator.getStats().getAttributes();
        View.jTextField2.setText((stats.get("Strength")).toString());
        View.jTextField3.setText((stats.get("Dexterity")).toString());
        View.jTextField4.setText((stats.get("Constitution")).toString());
        View.jTextField5.setText((stats.get("Intellect")).toString());
        View.jTextField6.setText((stats.get("Wisdom")).toString());
        View.jTextField7.setText((stats.get("Charisma")).toString()); 
        
    }

    static void save() {
        model.getCareTaker().save(model.getOriginator().saveStateToMemento());
        
        View.jTextArea1.setText("State was saved to archive");

    }

    static void returnLastSave() {
        model.getOriginator().getStateFromMemento(model.getCareTaker().get());
        HashMap <String, Integer> stats = model.getOriginator().getStats().getAttributes();
        View.jTextField2.setText((stats.get("Strength")).toString());
        View.jTextField3.setText((stats.get("Dexterity")).toString());
        View.jTextField4.setText((stats.get("Constitution")).toString());
        View.jTextField5.setText((stats.get("Intellect")).toString());
        View.jTextField6.setText((stats.get("Wisdom")).toString());
        View.jTextField7.setText((stats.get("Charisma")).toString());
        
        View.jTextArea1.setText("Last saved state was pulled from archive");
    }

    static void createCharacter() {
        
        try{
        
        String name = View.jTextField1.getText();
       
        if(name.isBlank() ||  name.equalsIgnoreCase("Type your name")) throw new IllegalArgumentException();
        
        CharacterRace ra = 
        switch(View.jComboBox1.getSelectedIndex()){
            case 0:
                yield new DragonbornFactory().create();
            case 1:
                yield new HumanFactory().create();
            default: 
                yield null;
        };
        
        CharacterClass cl = new ClassFactory().getClass(View.jComboBox2.getSelectedItem().toString());
        
        Stats stats = model.getOriginator().getStats();
        
        Character ch = new Character(name, cl, ra, stats);
        ch.addBonuses();
        model.getCharacters().add(ch);
        
        View.listModel.addElement(ch.toString());
        
        View.jTextArea1.setText("Character created");
        View.jTextField1.setText("Type your name");
        View.jTextField2.setText("");
        View.jTextField3.setText("");
        View.jTextField4.setText("");
        View.jTextField5.setText("");
        View.jTextField6.setText("");
        View.jTextField7.setText("");
        
        model.getOriginator().clear();
        }
        catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "Generate attributes!!!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        catch(IllegalArgumentException e){
            JOptionPane.showMessageDialog(null, "Set name for your character", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    static void saveJSON() throws IOException {
        String str = "[\n";
        
        ArrayList <DataElement> list = new ArrayList<>();
        for(Character ch: model.getCharacters()){
            model.getJson().clear();
            list.clear();
            
            list.add(ch);
            list.add(ch.getDndClass());
            list.add(ch.getRace());
            list.add(ch.getStats());
            
            for(DataElement element: list){
                model.getJson().putAll(element.access(model.getVisitor()));
            }
            
            str+= model.getJson().toJSONString();
            
            
            if(model.getCharacters().indexOf(ch)!= model.getCharacters().size()-1){
                str+=",\n";
            }     
        }
        
        str+="\n]";
        
        View.jTextArea2.setText(str);
        
        FileWriter file = new FileWriter("../../output.json");
        
        file.write(str);
        file.close();
    }

    static void showAttributes() {
        Character ch = model.getCharacters().get(View.jList1.getSelectedIndex());
        View.jTextArea1.setText(ch.getStats().print());
    }
}
