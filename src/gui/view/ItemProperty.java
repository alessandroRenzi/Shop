package gui.view;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.StringProperty;

public interface ItemProperty {
	public StringProperty getDescription();
	public void setDescription(StringProperty description);
	public StringProperty getCategory();
	public void setCategory(StringProperty category);
	public DoubleProperty getPrice();
	public void setPrice(DoubleProperty price);
}
