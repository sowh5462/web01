package Model;

import java.sql.*;
import java.util.ArrayList;

public class PostDAO {
	//게시글목록
	public ArrayList<PostVO> list(){
		ArrayList<PostVO> array = new ArrayList<PostVO>();
		try {
			String sql = "select * from posts order by id desc limit 0, 5";
			PreparedStatement ps = DB.CON.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				PostVO vo = new PostVO();
				vo.setId(rs.getInt("id"));
				vo.setTitle(rs.getString("title"));
				vo.setBody(rs.getString("body"));
				vo.setWriter(rs.getString("writer"));
				vo.setDate(rs.getTimestamp("date"));
				array.add(vo);
//				System.out.println(vo.toString());
			}
		}catch(Exception e) {
			System.out.println("post list..."+e.toString());
		}
		
		return array;
	}
	
	//게시글등록
	public void insert(PostVO vo) {
		try {
			String sql = "insert into posts (title, body, writer) values (?, ?, ?)";
			PreparedStatement ps = DB.CON.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getBody());
			ps.setString(3, vo.getWriter());
			ps.execute();
		}catch(Exception e) {
			System.out.println("post insert..."+e.toString());
		}
	}
	
	//게시글조회
	public PostVO read(int id) {
		PostVO vo = new PostVO();
		try {
			String sql = "select * from posts where id=?";
			PreparedStatement ps = DB.CON.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				vo.setId(rs.getInt("id"));
				vo.setTitle(rs.getString("title"));
				vo.setBody(rs.getString("body"));
				vo.setWriter(rs.getString("writer"));
				vo.setDate(rs.getTimestamp("date"));
//				System.out.println(vo.toString());
			}
		}catch(Exception e) {
			System.out.println("post read..."+e.toString());
		}
		return vo;
	}
	
	//게시글삭제
	public void delete(int id) {
		try {
			String sql = "delete from posts where id = ?";
			PreparedStatement ps = DB.CON.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
		}catch(Exception e) {
			System.out.println("post delete..."+e.toString());
		}
	}
	
	//게시글수정
	public void update(PostVO vo) {
		try {
			String sql = "update posts set title=?, body=?, date=now() where id=?";
			PreparedStatement ps = DB.CON.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getBody());
			ps.setInt(3, vo.getId());
			ps.execute();
		}catch(Exception e) {
			System.out.println("post update..."+e.toString());
		}
	}
	
	
	
	
}
