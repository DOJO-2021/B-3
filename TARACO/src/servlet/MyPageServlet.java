package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProfileDAO;
import model.Profile;

/**
 * Servlet implementation class MyPageServlet
 */
@WebServlet("/MyPageServlet")
@MultipartConfig

public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//マイページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage/mypage.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//もしもログインしていなかったらログインサーブレットにリダイレクトする
		/*HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/TARACO/LoginServlet");
			return;
		}*/

		//リクエストパラメータを取得する
				request.setCharacterEncoding("UTF-8");
				String user_name = request.getParameter("NAME");
				String user_position = request.getParameter("POSITION");
				String user_class = request.getParameter("CLASS");
				String user_gender = request.getParameter("GENDER");
				String user_major = request.getParameter("MAJOR");
				String user_hobby = request.getParameter("HOBBY");
				String user_personarity = request.getParameter("PERSONARITY");
				String user_star = String.valueOf(request.getParameter("STAR"));
				String user_remarks = request.getParameter("REMARKS");
				String user_photo = request.getParameter("PHOTO");
				String user_DATE = request.getParameter("DATE");


				//検索処理を行う
				ProfileDAO pDao = new ProfileDAO();
				List<Profile> cardList = pDao.select(new Profile("","",user_name,user_position, "", "", "", "", "", 0, "", "", ""));


				//検索結果をリクエストスコープに格納する
				request.setAttribute("cardList",cardList);

				//プロフィール検索結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/profile/profile.jsp");
				dispatcher.forward(request, response);
	}

	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエスト領域の情報を取得するための処理
		Collection<Part> parts = request.getParts();
		//普通のformから取る場合
		 //String ar = request.getParmeter("nameの中身");

		 //受け取りたいもの
		 uploadfile:画像データとファイル名, item1:値, item2値, item3値

		 //送られたデータを（画像以外）すべて保持するためのHashMap
		 HashuMap<String,String> map = new HashMap<String,String>();

		 //アップされたファイル名（forループの中で取得）
		String uploadFileName = "";
		//画像を保存するパス
		//ここでは、PCのデスクトップに保存して確認できるようにしている
		String uploadFolder = "C:\\Users\\sep-other\\Desktop\\ImageSample\\ImageSample\\WebContent\\img\\uploaded\\";
		//実際は、下記のように「プロジェクト内のフォルダ」に格納する。
		//String uploadFolder = this.getServletContext().getRealPath("/img/uploaded/");

		//名前が決まってから画像を処理するために、Partを保持しておく
		Part imgPart = null;

		for(Part part:parts){ //partsから１つずつ取り出す
			String contentType = part.getContentType();
			if ( contentType == null) {
				//ここは通常のテキストやチェックボックス、セレクトなどのケース

				try(InputStream inputStream = part.getInputStream()) {
					BufferedReader bufReader = new BufferedReader(new InputStreamReader(inputStream));
					//実際のデータを取ってくる
					String val = (String)bufReader.lines().collect(Collectors.joining());
					//HTMLのnameとPOSTされたvalueをセットにして格納
					map.put(part.getName(), val);
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}else{
				//アップロードされたファイルの処理
				uploadFileName = this.getFileName(part);
				//実際には、ファイル名を商品IDなどに置き換えることになる（同一ファイル名対策）
								//ここだけコピペじゃなく、自分で実装すること
				part.write(uploadFolder + uploadFileName);

				//みなさんのシステムでは、AIを使っている場合、名前がまだ決まらない
				imgPart = part;
			}
		}

		//値の取り方
		//getParameter()の代わりにmapから、画面のHTMLで設定したname属性で取得する
		String item1 = map.get("item1");
		String item2 = map.get("item2");
		String item3 = map.get("item3");

		//ここでdaoを使って１行作成する

		//作成後に決まったIDの名前で画像を保存
		int newId = 100;//作ったデータの新しいID
		imgPart.write(uploadFolder + newId + ".jpg");



		/* ****************************** */
		/*
		//更新画面の場合
		BookDAO dao = new BookDAO();
		//更新対象行を取得する
		Book b = dao.selectById(id);
		// path /img/uploaded/湖.jpg
		//画面上の値で上書き
		b.setTitle(item1);
		b.setPrice(item2);
		//画像パスが「あれば」更新
		//ただし、画像のファイル名＝idである場合は、そもそも更新が必要ない
		if(imgPart != null){
			b.setFilePath(uploadFolder + uploadFileName);
		}
		*/


		//本来は取った値でデータベース操作を行う。
		//今回はサンプルなのでセッションに格納している。
		/*HttpSession session = request.getSession();
		session.setAttribute("filePath", uploadFolder + uploadFileName);
		session.setAttribute("item1", item1);
		session.setAttribute("item2", item2);
		session.setAttribute("item3", item3);

		//表示画面へGO
        response.sendRedirect("ResultServlet");
	}*/

   /* private String getFileName(Part part) {
        String name = null;
        for (String dispotion : part.getHeader("Content-Disposition").split(";")) {
            if (dispotion.trim().startsWith("filename")) {
                name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
                name = name.substring(name.lastIndexOf("\\") + 1);
                break;
            }
        }
        return name;
    }

		doGet(request, response);
	}*/

}
