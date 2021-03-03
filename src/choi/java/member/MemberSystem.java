package choi.java.member;
import java.io.*;
import java.util.*;
import java.util.Vector;


public class MemberSystem{
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   Vector<MemberSave> members = new Vector<MemberSave>();
   String name; // 회원 수정과 탈퇴를 위한 전역변수 name 
   // 메뉴선택
   int menu() throws IOException {
      System.out.println("1. 회원가입");
      System.out.println("2. 회원검색");
      System.out.println("3. 정보수정");
      System.out.println("4. 회원탈퇴");
      System.out.println("5. 전체목록");
      System.out.println("0. 프로그램종료");
      System.out.print("메뉴선택 : ");
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
            System.out.print("정말로 종료하시겠습니까? (y/n)");
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
   
   //회원가입 메서드
   void addMember() throws IOException {
      String name = "";
      int age = 0;
      String number = "";
      String addr = "";
      System.out.print("이름 : ");
      name = br.readLine();
      
      System.out.print("나이 : ");
      age = Integer.parseInt(br.readLine());
      
      System.out.print("번호 : ");
      number = br.readLine();
      
      System.out.print("주소 : ");
      addr = br.readLine();
      
      MemberSave mbs = new MemberSave(name, age, number, addr);
      members.add(mbs);
      System.out.println("회원가입이 완료되었습니다");
      System.out.println();
   }// end addMember
   
   
   
   // 멤버 검색
   void searchMember() throws IOException {
      System.out.print("검색할 회원 이름 : ");
      name = br.readLine();
      MemberSave member = Find(name);
      if(member==(null)) {
         System.out.println("없는 회원입니다");
         System.out.println();
         return;
      }
      System.out.println(member.toString()+"검색에 성공하셨습니다");
      System.out.println();
      
      
   } // end searchMember
   
   
   //멤버 수정
   void modifyMember() throws IOException{
      int num;
      MemberSave member = Find(name);
      if(member==null) {
         System.out.println("회원 검색을 먼저 수행하셔야 합니다");
         System.out.println();
         return;
      }
      System.out.println("1. 연락처 수정");
      System.out.println("2. 주소록 수정");
      System.out.println("0. 수정 취소");
      System.out.print("메뉴 선택");
      num = System.in.read() -48;
      System.in.read();System.in.read();
      System.out.println();
      
      if(num !=0 && num!=1 && num!=2)
         modifyMember();
      if(num == 0) {
         System.out.println(member.getName() +"님의 정보를 수정합니다");
         System.out.println(member.getName() + "님의 수정을 취소하였습니다");
         System.out.println();
         return;
      }else {
         if(num == 1) {
            System.out.println(member.getName() + "님의 정보를 수정합니다");
            System.out.print("수정할 번호 : ");
            String number = br.readLine();
            System.out.println("성공적으로 수정하였습니다");
            member.setNumber(number);
            System.out.println();
         }else if(num == 2) {
            System.out.println(member.getName() + "님의 정보를 수정합니다");
            System.out.print("수정할 주소 : ");
            String addr = br.readLine();
            member.setAddr(addr);
            System.out.println("성공적으로 수정하였습니다");
            System.out.println();
         }//end if(num == 1 || num ==2)
      }  // end if(num==0)
   } // end modifyMember
   
   
   //멤버 삭제
   void removeMember() {
      
      MemberSave member = Find(name);
      
      if(member == null) {
         System.out.println("회원검색을 먼저 해주세요");
         System.out.println();
         return;
      }
      members.remove(member);
      System.out.println(member.getName() +"회원을 삭제하였습니다.");
      System.out.println();
   } // end removeMember
   
   
   //멤버리스트
   void listMember() {
      System.out.println("===== 전체 목록 =====");
      for(MemberSave member : members) {
         System.out.println(member.toString());
         System.out.println("---------------");
      }
      System.out.println();
   } // end listMember
   
   
   // MemberSave에 저장된 값을찾는 메서드
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