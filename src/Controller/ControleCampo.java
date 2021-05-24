package Controller;

import javax.swing.text.*;

public class ControleCampo extends PlainDocument {

    private static final long serialVersionUID = 1L;

    public enum EnumCampo {
        PADRAO, SOMENTE_LETRAS, SOMENTE_LETRAS_ESPACO, SOMENTE_LETRAS_NUMERO, SOMENTE_LETRAS_NUMERO_ESPACO,
        SOMENTE_NUMERO, SOMENTE_NUMERO_ESPACO, CASAS_DECIMAIS;
    }

    
    public static final int tamanhoTelefone = 11;

    private int iMaxLength;
    private EnumCampo tipo;

    public ControleCampo(int maxlen, EnumCampo tipo) {
        super();
        iMaxLength = maxlen;
        this.tipo = tipo;
    }

    public ControleCampo(int maxlen) {
        super();
        iMaxLength = maxlen;
        tipo = EnumCampo.PADRAO;
    }

    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null)
            return;

        if (!isAceito(str))
            return;

        if (iMaxLength <= 0) // aceitara qualquer no. de caracteres
        {
            super.insertString(offset, str, attr);
            return;
        }

        int ilen = (getLength() + str.length());
        if (ilen <= iMaxLength) // se o comprimento final for menor...
            super.insertString(offset, str, attr); // ...aceita str
        else {
            if (getLength() == iMaxLength)
                return; // nada a fazer
            String newStr = str.substring(0, (iMaxLength - getLength()));

            super.insertString(offset, newStr, attr);
        }
    }

    private boolean isAceito(String str) {

        if (tipo == EnumCampo.PADRAO)
            return true;

        for (int i = 0; i < str.length(); i++) {

            if (tipo == EnumCampo.SOMENTE_LETRAS && !Character.isLetter(str.charAt(i)))
                return false;
            else if (tipo == EnumCampo.SOMENTE_LETRAS_ESPACO && !Character.isSpaceChar(str.charAt(i))
                    && !Character.isLetter(str.charAt(i)))
                return false;
            else if (tipo == EnumCampo.SOMENTE_LETRAS_NUMERO && !Character.isDigit(str.charAt(i))
                    && !Character.isLetter(str.charAt(i)))
                return false;
            else if (tipo == EnumCampo.SOMENTE_LETRAS_NUMERO_ESPACO && !Character.isSpaceChar(str.charAt(i))
                    && !Character.isLetter(str.charAt(i)) && !Character.isDigit(str.charAt(i)))
                return false;
            else if (tipo == EnumCampo.SOMENTE_NUMERO && !Character.isDigit(str.charAt(i)))
                return false;
            else if (tipo == EnumCampo.SOMENTE_NUMERO_ESPACO && !Character.isDigit(str.charAt(i))
                    && !Character.isSpaceChar(str.charAt(i)))
                return false;
           

        }

        return true;
    }
}
