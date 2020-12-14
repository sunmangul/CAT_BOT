package ddackcat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.javacord.api.event.message.MessageCreateEvent;

public class ReadFile {
	protected static void work(String mes, MessageCreateEvent event) {
		try {
			String path = "D:\\JAVA\\WORKSPACE\\ddackcat\\";
			if (mes.contains("���ұ�") || mes.contains("������")) {
				path = path + "work.txt";
			}
			if (mes.contains("����")) {
				path = path + "do.txt";
			}
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "euc-kr"));
			int cnt = 0, rand;
			String read, memodana;
			List<String> list = new ArrayList<String>();

			while ((read = br.readLine()) != null) {
				memodana = read;
				list.add(memodana);
				cnt++;
			}

			if (list.size() != 0) {
				rand = (int) (Math.random() * (cnt));

				event.getChannel().sendMessage(list.get(rand));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	protected static String liiist(String mes, MessageCreateEvent event) {
		String send = "";
		try {
			String path = "D:\\JAVA\\WORKSPACE\\ddackcat\\rep.txt";
			BufferedReader br = new BufferedReader(new FileReader(path));

			String read;
			String[] read1;

			while ((read = br.readLine()) != null) {
				read1 = read.split(":");
				send += (read1[0] + "\n");
			}

		} catch (Exception p) {
			p.printStackTrace();
		}
		return send;

	}

	protected static void comment(String mes, MessageCreateEvent event) {
		try {
			String path = "D:\\JAVA\\WORKSPACE\\ddackcat\\rep.txt";
			BufferedReader br = new BufferedReader(new FileReader(path));
			int cnt = 0, tni;
			String read, replacedAns;
			String[] memodana;
			List<String> list = new ArrayList<String>();
			while ((read = br.readLine()) != null) {
				memodana = read.split(":");
				if (memodana[0].equals(mes.replace("������ ", ""))) {
					list.add(memodana[1]);
					cnt++;
				}
			}
			if (list.size() != 0) {
				tni = (int) (Math.random() * (cnt));
				replacedAns = list.get(tni);
				event.getChannel().sendMessage(replacedAns);
			} else {
				int random = (int) (Math.random() * 3);
				switch (random) {
				case 1:
					event.getChannel().sendMessage("����..?");
					break;
				case 2:
					event.getChannel().sendMessage("����...");
					break;
				}
			}
		} catch (Exception p) {
			p.printStackTrace();
		}

	}

	protected static void remember(String mes, MessageCreateEvent event) {
		try {
			String path = "D:\\JAVA\\WORKSPACE\\ddackcat\\rep.txt";
			File file = new File(path);
			String sb = "";
			String learn;
			String[] dana1 = null;

			learn = mes.replace("������ �ؾ� ", "");
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			String dana;
			boolean isAlready = false;

			while ((dana = br.readLine()) != null) {
				dana1 = dana.split(":");

				if (learn.equals(dana1[0])) {
					isAlready = true;
				} else {
					sb += (dana + "\r\n");
				}
			}
			if (isAlready) {
				FileWriter fw = new FileWriter(path);
				event.getChannel().sendMessage("��.. �װ�... ����� ���� �ʾƿ�");
				fw.write(sb);
				fw.close();
				br.close();
			} else {
				event.getChannel().sendMessage("��� ����� ���°�");
			}
		} catch (Exception p) {
			p.printStackTrace();
		}
	}

	protected static void learn(String mes, MessageCreateEvent event) {
		try {
			String path = "D:\\JAVA\\WORKSPACE\\ddackcat\\rep.txt";
			BufferedWriter bw = new BufferedWriter(new FileWriter(path, true));
			final PrintWriter pw = new PrintWriter(bw, true);

			String learn;
			String[] learn1, dana1 = null;

			learn = mes.replace("������ ��� ", "");
			learn1 = learn.split(":");

			if (learn.contains(":")) {
				BufferedReader br = new BufferedReader(new FileReader(path));
				String dana;
				boolean isAlready = false;

				while ((dana = br.readLine()) != null) {
					dana1 = dana.split(":");
					if (dana1[0].equals(learn1[0]))
						isAlready = true;
				}
				if (isAlready)
					event.getChannel().sendMessage("�� �װ� �װ� �̹� �˾�!");
				else {
					pw.write(learn + "\n");
					pw.flush();
					event.getChannel().sendMessage("����... �� ������� �ܿ� ����!");
					pw.close();
				}
				br.close();
			} else {
				event.getChannel().sendMessage("������ ��� (�ܾ�):(����)�� �����ָ� �� ������!");
			}
		} catch (Exception p) {
			p.printStackTrace();
		}
	}

}
