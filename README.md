# 게시판 프로젝트

> 프로젝트 주제

spring을 사용해 간단한 게시판 프로젝트를 진행해서 spring에 익숙해지기.

로그인 , CRUD 기능과 같은 기능들을 구현함으로써 다양한 기능들을 공부.

***

> 사용기술은 다음과 같습니다.
  * java
  * spring
  * mybatis
  * mysql


> 주요기능은 다음과 같습니다.
  - 로그인 기능
  - 글 CRUD 기능
  - 글 검색 기능
  - 파일 업로드 기능
  
***
  
> BoardController중 일부

```java
@Controller
@SessionAttributes("board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/dataTransform.do")
	@ResponseBody
	public BoardListVO dataTransform(BoardVO vo) {
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		List<BoardVO> boardList = boardService.getBoardList(vo);
		BoardListVO boardListVO = new BoardListVO();
		boardListVO.setBoardList(boardList);
		return boardListVO;
	}
	
	//글 등록
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IOException {
		//파일 업로드 처리
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("/Users/an-yohan/Documents/JAVA/Spring/" + fileName));
			
		}
				
		boardService.insertBoard(vo);
		return "getBoardList.do";
	}
	
	//글 수정
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) { 
		boardService.updateBoard(vo);
		return "getBoardList.do";
	}
	
	//글 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		boardService.deleteBoard(vo);
		return "getBoardList.do";
	}
  
}
  
```




