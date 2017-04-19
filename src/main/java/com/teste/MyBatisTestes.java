package com.teste;

import org.apache.ibatis.jdbc.SQL;

public class MyBatisTestes {

	public static void main(String[] args) {
		
		SQL sql = new SQL();
		sql.SELECT("cd_pedido_palm AS [cdPedidoPalm], P.cd_vendedor AS [vendedor.cdVendedor], U.ds_email AS [vendedor.email]");
		sql.FROM("bd_ssm_softsite.dbo.PEDIDO P");
		sql.LEFT_OUTER_JOIN("bd_ssm_softsite.dbo.DADOS_VENDEDOR DV ON P.CD_VENDEDOR = DV.CD_VENDEDOR");
		sql.LEFT_OUTER_JOIN("bd_ssm_softsite.dbo.TUSUARIO U ON DV.CD_USUARIO_SEGURANCA = U.CD_USUARIO");
		sql.AND().WHERE("id_efetivado <> 'C' OR id_efetivado IS NULL");
		sql.AND().WHERE("dt_exportacao IS NULL");
			
		System.out.println(sql.toString());
		
	}

}
