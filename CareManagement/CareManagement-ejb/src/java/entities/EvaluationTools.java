/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.LinkedList;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 *
 * @author André Nunes
 */
@Entity
@Table(name = "EVALUATION_TOOLS",
uniqueConstraints =
@UniqueConstraint(columnNames = {"ID", "DESCRIPTION"}))
public class EvaluationTools implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String description;

    @NotNull
    private String question1;
    
    private String question2;
    
    private String question3;
    
    private String question4;
    
    @OneToMany(mappedBy = "evaluationTool", cascade = CascadeType.REMOVE)
    private LinkedList<Classification> classifications;

    public EvaluationTools() {
    }

    public EvaluationTools(String description, String question1, String question2, String question3, String question4) {
        this.description = description;
        this.question1 = question1;
        this.question2 = question2;
        this.question3 = question3;
        this.question4 = question4;
        this.classifications = new LinkedList<>();
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion1() {
        return question1;
    }

    public void setQuestion1(String question1) {
        this.question1 = question1;
    }

    public String getQuestion2() {
        return question2;
    }

    public void setQuestion2(String question2) {
        this.question2 = question2;
    }

    public String getQuestion3() {
        return question3;
    }

    public void setQuestion3(String question3) {
        this.question3 = question3;
    }

    public String getQuestion4() {
        return question4;
    }

    public void setQuestion4(String question4) {
        this.question4 = question4;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LinkedList<Classification> getClassifications() {
        return classifications;
    }

    public void setClassifications(LinkedList<Classification> classifications) {
        this.classifications = classifications;
    }
    
    public void removeClassification(Classification c) {
        this.classifications.remove(c);
    }
    
    public void addClassification(Classification c){
        this.classifications.add(c);
    }
    
}
