package com.edutecno.dao;

import java.sql.Connection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edutecno.modelo.Horoscopo;
import com.edutecno.procesaconexion.AdministradorConexion;

public class HoroscopoDaoImp extends AdministradorConexion implements HoroscopoDao {

	public List<Horoscopo> obtenerHoroscopo() {
		List<Horoscopo> horoscopo = new ArrayList<>();
		String consultaSql = " SELECT * FROM HOROSCOPO ";
		Connection conn = generaPoolConexion();

		try {
			pstm = conn.prepareStatement(consultaSql);
			rs = pstm.executeQuery();
			while (rs.next()) {

				// Horoscopo(String animal, Date fecha_inicio, Date fecha_fin)
				Horoscopo h = new Horoscopo(rs.getString("animal"), rs.getDate("fecha_inicio"),
						rs.getDate("fecha_fin"));
				horoscopo.add(h);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return horoscopo;

	}

}
