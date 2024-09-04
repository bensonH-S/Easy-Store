/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nfce.teste;

import br.com.samuelweb.certificado.Certificado;
import br.com.samuelweb.certificado.CertificadoService;
import br.com.samuelweb.certificado.exception.CertificadoException;
import br.com.samuelweb.nfe.dom.ConfiguracoesIniciaisNfe;
import br.com.samuelweb.nfe.exception.NfeException;
import br.com.samuelweb.nfe.util.ConstantesUtil;
import br.com.samuelweb.nfe.util.Estados;
import java.io.File;

/**
 *
 * @author deivid
 */
public class ConstantesNFCE {

    public static String uf;
    public static String senha;
    public static String caminhoSchema;
    public static String caminhoA1;
    public static String rotuloA3;
    public static String idTokencsc;
    public static String csc;

    static {
        uf = "DF";
        csc="";
        idTokencsc="";
        senha = "123123";
        caminhoA1 = "C:\\a1.pfx";
        caminhoSchema = System.getProperty("user.dir")
                + File.separator + "test"
                + File.separator + "nfce"
                + File.separator + "schemas";
    }

    public static ConfiguracoesIniciaisNfe iniciaConfiguraçõesA3() throws NfeException, CertificadoException, CertificadoException, CertificadoException {
        // Certificado Windows
        Certificado certificado = null;
        for (Certificado cert : CertificadoService.listaCertificadosWindows()) {
            if (cert.getNome().equals(rotuloA3)) {
                certificado = cert;
                break;
            }
        }

        return ConfiguracoesIniciaisNfe.iniciaConfiguracoes(
                Estados.valueOf(uf),
                ConstantesUtil.AMBIENTE.HOMOLOGACAO,
                certificado,
                caminhoSchema);
    }

    public static ConfiguracoesIniciaisNfe iniciaConfiguraçõesA1() throws NfeException, CertificadoException, CertificadoException {
        // Certificado Arquivo, Parametros: -Caminho Certificado, - Senha
        Certificado certificado = CertificadoService.certificadoPfx(
                caminhoA1,
                senha);

        return ConfiguracoesIniciaisNfe.iniciaConfiguracoes(
                Estados.valueOf(uf),
                ConstantesUtil.AMBIENTE.HOMOLOGACAO,
                certificado,
                caminhoSchema);
    }

}
