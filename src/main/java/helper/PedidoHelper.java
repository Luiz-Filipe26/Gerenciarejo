
package helper;
import classes.PedidoVO;
import java.util.ArrayList;

public class PedidoHelper {
    
    private static PedidoHelper instance;
    
    private ArrayList<PedidoVO> listaPedidos;

    public PedidoHelper() {
        listaPedidos = new ArrayList<PedidoVO>();
    }

    public static PedidoHelper getInstance() {
        if(instance == null){
            instance = new PedidoHelper();
        }
        return instance;
    }

    public static void setInstance(PedidoHelper instance) {
        PedidoHelper.instance = instance;
    }

    public ArrayList<PedidoVO> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(ArrayList<PedidoVO> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }
    
    public int adicionarPedido(PedidoVO pedidoVO){
        listaPedidos.add(pedidoVO);
        return 1;
    }
    
    public int removerPedido(PedidoVO pedidoVO){     // Remove o pedido do usuário
        int contador=0;
        for (int i=0; i<listaPedidos.size();i++){
            if(listaPedidos.get(i).getId() == pedidoVO.getId()){
                if (listaPedidos.remove(listaPedidos.get(i))){
                    contador++;
                }
            }
        }
        return contador;        
    }
    public PedidoVO pesquisarPedido(long id){       // Pesquisa o número do pedido do usuário

        for (int i=0; i<listaPedidos.size();i++){
            if(listaPedidos.get(i).getId() == id){
                return listaPedidos.get(i);
            }
        }
        return null;
    }
    
    public int atualizarPedidos(PedidoVO pedidoVO){      //Atualiza quantos pedidos foram alterados
        PedidoVO temp=null;
        int numeroRegistrosAlterados=0;
        for (int i=0; i< listaPedidos.size();i++){
            temp = listaPedidos.get(i);
            if(temp.getId()== pedidoVO.getId()){
                temp.setDescricao(pedidoVO.getDescricao());
                numeroRegistrosAlterados = 1;
            }
        }
        return numeroRegistrosAlterados;
    }
    
    public String[] getCodigos(){      // Lista os ids dos pedidos

        String[] listaId = new String[listaPedidos.size()];
        for (int i=0; i< listaPedidos.size();i++){
            listaId[i]= "" + listaPedidos.get(i).getId();
        }
        return listaId;
    }  
    
   

    
     
    
    
}
