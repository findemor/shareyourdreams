package topoos.Objects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that implements a collection of Image.
 *
 * @author DMC
 */
public class ImageCollection implements Serializable{

	/**
	 * V0
	 */
	private static final long serialVersionUID = 1L;

	/** The Image list. */
	private List<Image> imageList = null;

	/**
	 * Instantiates a new pOI collection.
	 *
	 * @param imageList the iamge list
	 */
	public ImageCollection(List<Image> imageList) {
		super();
		this.imageList = imageList;
	}

	/**
	 * Get the imageList.
	 *
	 * @return the imageList
	 */
	public List<Image> getImageList() {
		return imageList;
	}

	/**
	 * Sets the image list.
	 *
	 * @param imageList the imageList to set
	 */
	public void setPoiList(List<Image> imageList) {
		this.imageList = imageList;
	}
}
