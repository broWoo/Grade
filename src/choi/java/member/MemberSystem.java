package choi.java.member;
import java.io.*;
import java.util.*;
import java.util.Vector;


public class MemberSystem{
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   Vector<MemberSave> members = new Vector<MemberSave>();
   String name; // ȸ�� ������ Ż�� ���� �������� name 
   // �޴�����
   int menu() throws IOException {
      System.out.println("1. ȸ������");
      System.out.println("2. ȸ���˻�");
      System.out.println("3. ��������");
      System.out.println("4. ȸ��Ż��");
      System.out.println("5. ��ü���");
      System.out.println("0. ���α׷�����");
      System.out.print("�޴����� : ");
      int key = System.in.read() -48;
      System.out.println();
      System.in.read(); System.in.read();
      
      
      
      return key;
   }
   
   public void Run() throws IOException {
      int key;
      char key2;
      while((key = menu())!= -1) {
         if(key == 0) {
            System.out.print("������ �����Ͻðڽ��ϱ�? (y/n)");
            key2 = (char)System.in.read();
            System.in.read(); System.in.read();
            if(key2 == 'y' || key2 == 'Y') {
               System.exit(0);
            } //end program
         }else {
            switch(key) {
            case 1: addMember(); break;
            case 2: searchMember(); break;
            case 3: modifyMember(); break;
            case 4: removeMember(); break;
            case 5: listMember(); break;
            }// end switch
         } // end if Run
      }// end while Run
   } // end Run()
   
   //ȸ������ �޼���
   void addMember() throws IOException {
      String name = "";
      int age = 0;
      String number = "";
      String addr = "";
      System.out.print("�̸� : ");
      name = br.readLine();
      
      System.out.print("���� : ");
      age = Integer.parseInt(br.readLine());
      
      System.out.print("��ȣ : ");
      number = br.readLine();
      
      System.out.print("�ּ� : ");
      addr = br.readLine();
      
      MemberSave mbs = new MemberSave(name, age, number, addr);
      members.add(mbs);
      System.out.println("ȸ�������� �Ϸ�Ǿ����ϴ�");
      System.out.println();
   }// end addMember
   
   
   
   // ��� �˻�
   void searchMember() throws IOException {
      System.out.print("�˻��� ȸ�� �̸� : ");
      name = br.readLine();
      MemberSave member = Find(name);
      if(member==(null)) {
         System.out.println("���� ȸ���Դϴ�");
         System.out.println();
         return;
      }
      System.out.println(member.toString()+"�˻��� �����ϼ̽��ϴ�");
      System.out.println();
      
      
   } // end searchMember
   
   
   //��� ����
   void modifyMember() throws IOException{
      int num;
      MemberSave member = Find(name);
      if(member==null) {
         System.out.println("ȸ�� �˻��� ���� �����ϼž� �մϴ�");
         System.out.println();
         return;
      }
      System.out.println("1. ����ó ����");
      System.out.println("2. �ּҷ� ����");
      System.out.println("0. ���� ���");
      System.out.print("�޴� ����");
      num = System.in.read() -48;
      System.in.read();System.in.read();
      System.out.println();
      
      if(num !=0 && num!=1 && num!=2)
         modifyMember();
      if(num == 0) {
         System.out.println(member.getName() +"���� ������ �����մϴ�");
         System.out.println(member.getName() + "���� ������ ����Ͽ����ϴ�");
         System.out.println();
         return;
      }else {
         if(num == 1) {
            System.out.println(member.getName() + "���� ������ �����մϴ�");
            System.out.print("������ ��ȣ : ");
            String number = br.readLine();
            System.out.println("���������� �����Ͽ����ϴ�");
            member.setNumber(number);
            System.out.println();
         }else if(num == 2) {
            System.out.println(member.getName() + "���� ������ �����մϴ�");
            System.out.print("������ �ּ� : ");
            String addr = br.readLine();
            member.setAddr(addr);
            System.out.println("���������� �����Ͽ����ϴ�");
            System.out.println();
         }//end if(num == 1 || num ==2)
      }  // end if(num==0)
   } // end modifyMember
   
   
   //��� ����
   void removeMember() {
      
      MemberSave member = Find(name);
      
      if(member == null) {
         System.out.println("ȸ���˻��� ���� ���ּ���");
         System.out.println();
         return;
      }
      members.remove(member);
      System.out.println(member.getName() +"ȸ���� �����Ͽ����ϴ�.");
      System.out.println();
   } // end removeMember
   
   
   //�������Ʈ
   void listMember() {
      System.out.println("===== ��ü ��� =====");
      for(MemberSave member : members) {
         System.out.println(member.toString());
         System.out.println("---------------");
      }
      System.out.println();
   } // end listMember
   
   
   // MemberSave�� ����� ����ã�� �޼���
   MemberSave Find(String name) {
      for(MemberSave member : members) {
         if(member.getName().equals(name)) {
            return member;
         }
      }
      return null;
   } // end MemberSave
   
   
   public static void main(String[] args) throws IOException {
      MemberSystem mbs = new MemberSystem();
      mbs.Run();
   }
   
}