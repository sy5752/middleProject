package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import ibatis.config.SqlMapClientFactory;
import vo.MemberInfoVO;
import vo.ResvlogVO;
import vo.RoomVO;
import vo.VoteVO;

public class HotelDaoImpl implements IHotelDao {

	private SqlMapClient client;
	private static IHotelDao dao;

	private HotelDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}

	public static IHotelDao getDao() {
		if (dao == null)
			dao = new HotelDaoImpl();
		return dao;
	}

	@Override
	public List<ResvlogVO> resvLogAllList() throws SQLException {
		// TODO Auto-generated method stub
		return client.queryForList("resvlog.getresvLogAllList2");
	}

	@Override
	public int resvStatusUpdate(ResvlogVO vo) throws SQLException {
		return client.update("resvlog.resvLogUpdate", vo);
	}

	@Override
	public List<RoomVO> getRoomPlList() throws SQLException {
		return client.queryForList("room.getRoomPl");
	}

	@Override
	public List<RoomVO> getRoomTypeList(String room_pl) throws SQLException {
		return client.queryForList("room.getRoomType", room_pl);
	}

	@Override
	public List<RoomVO> getRoomNo(Map<String, String> map) throws SQLException {
		return (List<RoomVO>) client.queryForList("room.getRoomNo", map);
	}

	@Override
	public String selectById(String id) throws SQLException {
		// TODO Auto-generated method stub
		return (String) client.queryForObject("memberinfo.selectById", id);
	}

	@Override
	public String insertMember(MemberInfoVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return (String) client.insert("memberinfo.insertMember", vo);
	}

	@Override
	public int updateMemberVote(VoteVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return (Integer) client.update("memberVote.updateMemberVote", vo);
	}

	@Override
	public List<VoteVO> votelistAll() throws SQLException {

		return client.queryForList("memberVote.votelistAll");
	}

	@Override
	public List<RoomVO> getRoomInfoList() throws SQLException {
		return client.queryForList("room.getRoomInfoList");
	}

	@Override
	public int updateRoomStatus(Map<String, Object> map) throws SQLException {
		return client.update("room.updateRoomStatus", map);
	}

	@Override
	public int insertRoom(Map<Object, Object> map) throws SQLException {

		int res = 0;

		map = (Map<Object, Object>) client.insert("room.insertRoom", map);

		if (map == null) {
			res = 1;
			System.out.println("dao�뿉 �엳�뒗 if�쓽 res 媛�" + res);
		} else {
			res = 0;
			System.out.println("dao�뿉 �엳�뒗 else�쓽 res 媛�" + res);
		}

		return res;

	}
	@Override
	public int deleteRoom(Map<String, Object> map) throws SQLException {

		int res = 0;

		map = (Map<String, Object>) client.insert("room.deleteRoom", map);

		if (map == null) {
			res = 1;
			System.out.println("dao�뿉 �엳�뒗 if�쓽 res 媛�" + res);
		} else {
			res = 0;
			System.out.println("dao�뿉 �엳�뒗 else�쓽 res 媛�" + res);
		}

		return res;
	}

}
