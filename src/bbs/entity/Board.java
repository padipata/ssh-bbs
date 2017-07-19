package bbs.entity;

/**
 * Board entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class Board implements java.io.Serializable {

	// Fields

	private Integer boardId;
	private String boardName;
	private Integer parentId;

	// Constructors

	/** default constructor */
	public Board() {
	}

	/** full constructor */
	public Board(String boardName, Integer parentId) {
		this.boardName = boardName;
		this.parentId = parentId;
	}

	// Property accessors

	public Integer getBoardId() {
		return this.boardId;
	}

	public void setBoardId(Integer boardId) {
		this.boardId = boardId;
	}

	public String getBoardName() {
		return this.boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

}