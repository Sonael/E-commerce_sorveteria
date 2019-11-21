package dados;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import beans.Funcionario;
import exceptions.FuncionarioException;
import java.time.LocalDate;

public class RepositorioFuncionarios{
	ArrayList<Funcionario> funcionarios;
	File file;
	
	public RepositorioFuncionarios() {
		funcionarios = new ArrayList<Funcionario>();
		file =  new File("resource" + File.separatorChar+"arquivosPessoas"+  File.separatorChar+"arqFuncionario.txt");
		
	}
	


	public boolean cadastrar(String nome, String email, LocalDate dataNascimento, String senha, String cpf,
			LocalDate dataAdmissao, String tipoFuncionario) throws FuncionarioException, IOException {
		boolean cadastrado =false;
        Funcionario funcionario = new Funcionario(nome, email, dataNascimento, senha, cpf, dataAdmissao, tipoFuncionario);
		boolean resul = false;
		if(!file.exists()) {
			file.createNewFile();
		}
		
		if(funcionario != null)
		{
			Scanner scan =  new Scanner(file);
			while(scan.hasNext())
			{
				String linha =  scan.nextLine();
				if(linha.contains(funcionario.getCpf()))
				{
					resul = true;
				}
			}
			
			scan.close();
			if (!resul)
			{
				FileWriter w =  new FileWriter(file);
				w.append(funcionario.toString()+"\n");
				w.close();
				cadastrado = true;
				
			}
			
		}	
		return cadastrado;
	}
	
	


	public void remover(Funcionario funcionario) throws FuncionarioException, IOException {
		if(funcionario != null)
		{
			ArrayList<String> salvar =  new ArrayList<String>();
			Scanner scan =  new Scanner(file);
				
			while (scan.hasNext()) 
			{
				String linha =  scan.nextLine();
				if(!linha.contains(funcionario.getCpf()))
				{
					salvar.add(linha);
				}
					
			}
				
			scan.close();
				
			FileWriter w =  new FileWriter(file);
			for (int i = 0; i < salvar.size(); i++) 
			{
				w.write(salvar.get(i)+"\n");	
			}
				
			w.close();
			
		
	}
}


	public void atualizar(Funcionario funcionario) throws IOException, FuncionarioException {
		
		boolean resul =  false;
		if(funcionario != null)
		{
			ArrayList<String> salvar =  new ArrayList<String>();
			Scanner scan =  new Scanner(file);
				
			while (scan.hasNext()) 
			{
				String linha =  scan.nextLine();
				if(linha.contains(funcionario.getCpf()))
				{
					resul = true;
				}
					
			}
			
			
			if(resul ==  true)
			{
				while (scan.hasNext()) 
				{
					String linha =  scan.nextLine();
					if(!linha.contains(funcionario.getCpf()))
					{
						salvar.add(linha);
					}
						
				}
					
				scan.close();
				FileWriter w =  new FileWriter(file,true);
				for (int i = 0; i < salvar.size(); i++) 
				{
					w.write(salvar.get(i)+"\n");	
				}
				
				w.append(funcionario.toString());
					
				w.close();
			}
			
			else
			{
				FuncionarioException funcionarionexiste =  new FuncionarioException("O funcionario n existe");
				throw funcionarionexiste;
			}
		
	}
		
	}

	public boolean buscar(Funcionario funcionario) throws FileNotFoundException {
		
		Scanner scan =  new Scanner(file);
		boolean resul =  false;
		
		
		if(funcionario != null) 
		{
	
			while(scan.hasNext())
			{
				String linha = scan.nextLine();
				if(linha.contains(funcionario.getCpf()))
				{
					resul =  true;
				}
			}
			
		}
		scan.close();
		return resul;
	}
	
	

	
	
}
