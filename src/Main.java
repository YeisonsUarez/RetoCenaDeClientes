
import java.util.ArrayList;
import java.util.List;
import controller.CommandController;
import controller.DBController;
import model.ClientModel;
import model.FilterModel;
import model.InputTableModel;
import model.OutputTableModel;
import service.DecryptService;
import service.FileService;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBController dbController = new DBController();
		
		/*for(ClientModel client: dbController.getClients()) {
			System.out.printf("Id: %d - Código: %s - male: %b - Type: %d - location: %s - company: %s - encrypt: %b", client.getId(), client.getCode(),client.getMale(),client.getType(),client.getLocation(),client.getCompany(),client.getEncrypt());
		}*/
		
		//System.out.print();
		
		List<OutputTableModel> outputTables= new ArrayList<OutputTableModel>();
		
		List<InputTableModel> tables= FileService.processInput("C:\\Users\\yeiso\\Desktop\\Reto Java\\entrada.txt");
		for (InputTableModel table : tables) {
			String command= CommandController.getCommand(table);
			//System.out.println(command+"\n");
			List<ClientModel> clients = dbController.getClients(command);
			OutputTableModel outputTableModel= new OutputTableModel();
			outputTableModel.setName(table.getName());
			outputTableModel.setClients(clients);
			outputTables.add(outputTableModel);
		}
		
		for (OutputTableModel outputTable : outputTables) {
			System.out.print("<"+outputTable.getName()+">\n");
			if(outputTable.getClients().size()>0) {
				List<String> codes= new ArrayList<String>();
				for (ClientModel client : outputTable.getClients()) {
					if(client.getEncrypt()) {
						codes.add(DecryptService.getDecryptCode(client.getCode()));
					}else {
						codes.add(client.getCode());	
					}
					
				}
				System.out.println(String.join(",", codes));
			}else {
				System.out.println("CANCELADA");
			}
			
			//System.out.println("\n");
		}
	}

}
