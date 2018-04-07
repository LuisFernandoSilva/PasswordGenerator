package exercicioseguranca;

/**
* Exercicio de segurança de sistemas, implementação de programa que discriptografa 
* um texto, usando a tabela de frequencia de letras que aparece em textos
*/
public class ExercicioSegurança {


    public static void main(String[] args){
         
                String texto= "";
                String text = "D QBSXML JEDSGFDFB JEB EQ ABL XEQDPM UMFB HBL B D RMPFDFB. TDPH PDM \n" +
                "VMPVMLFDLGD. FM DSHM FB AED VDUDVGFDFB IGSMAMIGVD CBLQDPGVD, BSB \n" +
                "PDM VMPAGFBLDOD D RMPFDFB ULBFGVDFM. UML EQD LDZDM  GLLBFEHGOBS: \n" +
                "UML ABL GPDHD. JEBL FGZBL: D UBAAMD PDAVB VMQ DJEGSM, PDM AB BAIMLVD \n" +
                "UDLD AB-SM. VMQM D RBSBZD IGAGVD – PDM BKGAHB PBPXEQ QBLGHM PBSD, D \n" +
                "PDM ABL EQD XDLQMPGVD VMQRGPDVDM FB CBPBA.\n" +
                "\n" +
                "QDA, BQRMLD PDM XDND QBLGHMA, PDM XD PDFD FB BLLDFM BQ DFQGLDL JEBQ \n" +
                "IMG FMHDFM VMQ EQD RMD DUDLBPVGD ME VMQ EQ RMQ VMLDVDM. M QEPFM B \n" +
                "EQ SECDL QBSXML UDLD AB OGOBL JEDPFM DPFDQ AMRLB AED AEUBLIGVGB EQD \n" +
                "QBCDP IMK ME EQ CDPFXG.\n" +
                "\n" +
                "AM JEB D RBSBZD PDM VDPAD, QBAQM JEDPFM AELCB BQ BKVBAAM, VMQM D FB \n" +
                "VDHXBLGPB FBPBEOB BQ XMLDLGM PMRLB. RMPFDFB, AGQ. RMPFDFB FBQDGA \n" +
                "VDPAD.\n" +
                "\n" +
                "FGCM GAAM UMLJEB HBPXM EPA FMGA DQGCMA, PDM QDGA FM JEB FMGA, JEB \n" +
                "ADM HDM RMPZGPXMA JEB FBAUBLHDQ BQ QGQ M JEB HBPXM FB UGML. DJEBSD\n" +
                "RMPFDFB QBSBJEBPHD QB GLLGHD. JEBLM ABL QDE JEDPFM BAHME VMQ BSBA B,\n" +
                "M QDGA CLDOB, HLDPAIMLQM-QB, LBDSQBPHB, BQ EQD UBAAMD QD. OBNM \n" +
                "QDSGVGD BQ HEFM, BPKBLCM HMFMA UBSM SDFM LEGQ, AME  VLGHGVM B \n" +
                "DQDLCM, AME DCLBAAGOM, AME OBBQBPHB, AME VMQM DSCEPA\n" +
                "VMQBPHDLGAHDA FB RSMC.";
                
              //  System.out.println("Mensagem Criptografada:"+text);

                int contador = text.length();
                /**
                 * Ira percorrer a mensagem criptografada testando cada caracter e substituindo 
                 * pelo correspondente, montando em outra variavel que sera imprimindo na tela descriptografada
                */
		for(int i = 0; i < contador; ++i){
                    if (text.charAt(i)== 'D')
                        texto +='A';
                    else if (text.charAt(i)== 'B')
                        texto+='E'; 
                    else if  (text.charAt(i)== 'M')
                        texto += 'O';                     
                    else if  (text.charAt(i)== 'A')
                        texto+='S';
                    else if (text.charAt(i)== 'L')
                        texto+='R'; 
                    else if  (text.charAt(i)== 'F')
                        texto+='D';                    
                    else if  (text.charAt(i)== 'G')
                        texto+='I';
                    else if  (text.charAt(i)== 'Q')
                        texto+='M'; 
                    else if  (text.charAt(i)== 'P')
                        texto+='N';                    
                    else if  (text.charAt(i)== 'E')
                        texto+='U';
                    else if  (text.charAt(i)== 'H')
                        texto+='T'; 
                    else if  (text.charAt(i)== 'V')
                        texto+='C'; 
                    else if  (text.charAt(i)== 'U')
                        texto+= 'P';
                    else if  (text.charAt(i)== 'S')
                        texto+='L'; 
                    else if  (text.charAt(i)== 'J')
                        texto+='Q';                     
                    else if  (text.charAt(i)== 'C')
                        texto+='G';
                    else if  (text.charAt(i)== 'R')
                        texto+='B'; 
                    else if  (text.charAt(i)== 'O')
                        texto+='V'; 
                    else if  (text.charAt(i)== 'X')
                        texto+='H';
                    else if  (text.charAt(i)== 'I')
                        texto+='F'; 
                    else if  (text.charAt(i)== 'N')
                        texto+='J';                     
                    else if  (text.charAt(i)== 'Z')
                        texto+='Z';
                    else if  (text.charAt(i)== 'K')
                        texto+='X'; 
                    else if (text.charAt(i)== 'T')
                        texto+='K'; 
                    else{
                        texto+= text.charAt(i);
                    }
            		
                }   
                System.out.println();
                System.out.println();
		//System.out.println("Mensagem Descriptada  = " + texto);
     double g = 2;
     double n = 5;
     double x = 3;
   
    double  a =(double) Math.pow(g,x)%n;
    
    System.out.println(a);
   
                
    }
    

                
}
	
   

