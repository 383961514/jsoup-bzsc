package JDBC.model;

public class StatModel {
	private String  sqName;
	private String  oldName;
	private String  usName;
	private String  srcImage;
	private String  imageName;
	@Override
	public String toString() {
		return "StatModel [sqName=" + sqName + ", oldName=" + oldName + ", usName=" + usName + ", srcImage=" + srcImage
				+ ", imageName=" + imageName + "]";
	}
	public String getSqName() {
		return sqName;
	}
	public void setSqName(String sqName) {
		this.sqName = sqName;
	}
	public String getOldName() {
		return oldName;
	}
	public void setOldName(String oldName) {
		this.oldName = oldName;
	}
	public String getUsName() {
		return usName;
	}
	public void setUsName(String usName) {
		this.usName = usName;
	}
	public String getSrcImage() {
		return srcImage;
	}
	public void setSrcImage(String srcImage) {
		this.srcImage = srcImage;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
}
