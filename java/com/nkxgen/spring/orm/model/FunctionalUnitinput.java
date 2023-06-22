

package com.nkxgen.spring.orm.model;

public class FunctionalUnitinput {
private int modl_id;
private int funt_id;
private String funit_desc;
public int getModl_id() {
	return modl_id;
}
public void setModl_id(int modl_id) {
	this.modl_id = modl_id;
}
public int getFunt_id() {
	return funt_id;
}
public void setFunt_id(int funt_id) {
	this.funt_id = funt_id;
}
public String getFunit_desc() {
	return funit_desc;
}
public void setFunit_desc(String funit_desc) {
	this.funit_desc = funit_desc;
}
public FunctionalUnit toEntity() {
  Module module = new Module();
  module.setId(this.modl_id);
  
  FUnitId funitId = new FUnitId(module, this.funt_id);
  
  return new FunctionalUnit(funitId, this.funit_desc);
}
}

