package com.nkxgen.spring.orm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class FunctionalUnitId implements Serializable {
	@Column(name="funt_id")
    private int funId;

    @ManyToOne
    @JoinColumn(name = "modl_id")
    private Module module;

    public int getFunId() {
        return funId;
    }

    public void setFunId(int funId) {
        this.funId = funId;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }
}
