/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc;

import java.util.ArrayList;
import character.Character;
import memento.CareTaker;
import memento.Originator;
import org.json.simple.JSONObject;
import visitor.ElementVisitor;

/**
 *
 * @author 0802n
 */
public class Model {
    private ArrayList<Character> characters;
    private Originator originator;
    private CareTaker careTaker;
    private ElementVisitor visitor;
    private JSONObject json;
    
    public Model(){
        characters = new ArrayList<>();
        originator = new Originator();
        careTaker = new CareTaker();
        visitor = new ElementVisitor();
        json = new JSONObject();
    }

    public ArrayList<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(ArrayList<Character> characters) {
        this.characters = characters;
    }

    public Originator getOriginator() {
        return originator;
    }

    public void setOriginator(Originator originator) {
        this.originator = originator;
    }

    public CareTaker getCareTaker() {
        return careTaker;
    }

    public void setCareTaker(CareTaker careTaker) {
        this.careTaker = careTaker;
    }

    public ElementVisitor getVisitor() {
        return visitor;
    }

    public void setVisitor(ElementVisitor visitor) {
        this.visitor = visitor;
    }

    public JSONObject getJson() {
        return json;
    }

    public void setJson(JSONObject json) {
        this.json = json;
    }
    
    
}
