package jkor.testing_knowledge.entities.trans;

import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.MetaValue;
import javax.persistence.*;

import jkor.testing_knowledge.entities.*;

@MappedSuperclass
public abstract class Trans<T>
{
    @Id
    @GeneratedValue
    protected Long id;

    @Column(name="code_lang")
    protected String codeLang;

    @ManyToOne(fetch = FetchType.LAZY)   
    @JoinColumn(name = "obj_id", nullable = false)
    @AnyMetaDef(idType = "integer", metaType = "string",
        metaValues = {
            @MetaValue(value = "Topic", targetEntity = Topic.class),
            @MetaValue(value = "Question", targetEntity = Question.class),
            @MetaValue(value = "Answer", targetEntity = Answer.class)
        }
    )
    protected T obj;
    
    public Long getId()
    {
        return id;
    }

    public String getCodeLang() {
        return codeLang;
    }

    public void setCodeLang(String codeLang) {
        this.codeLang = codeLang;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}