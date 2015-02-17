package jkor.testing_knowledge.entities;

import org.springframework.context.i18n.LocaleContextHolder;
import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

import jkor.testing_knowledge.entities.trans.Trans;

@MappedSuperclass
public abstract class BaseEntity<T extends Trans>
{
    @Id
    @GeneratedValue
    protected Long id;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "obj")
    @MapKey(name = "codeLang")
    protected Map<String, T> trans;

    public Long getId() {
        return id;
    }

    public BaseEntity() {
        this.trans = new HashMap<String, T>();
    }

    public BaseEntity setId(Long id) {
        this.id = id;
        return this;
    }
    
    public static String getLocale() {
        return LocaleContextHolder.getLocale().getLanguage();
    }

    public abstract Map<String, Object> responseObj();
}
