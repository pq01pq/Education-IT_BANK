package test0910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

/**
고객관리 프로그램 : Customer Management [System or Service]

프로그램 시작 시

1. 고객 등록
2. 고객 검색
3. 고객 정보 수정
4. 고객 정보 삭제
5. 고객 목록 보기
0. 프로그램 종료
메뉴선택 : ______

1번 선택 시

고객이름 = _____
나이 = ______
전화번호 = ______
주소 = _____

성공적으로 등록되었습니다.

2번 선택 시

찾으시는 고객 이름 = ________

- 성공적으로 정보 검색에 성공했습니다. 
  홍길동:30:010:율도국

- 손오공님은 저희 회원이 아닙니다. 회원가입을 하세요.

2번 검색을 안하고 3번이나 4번을 선택하면 ...
- 정보검색을 먼저 수행 하셔야 합니다.

3번 선택 시

1. 전화번호 수정
2. 주소 수정
0. 수정 취소
메뉴선택 : ________

   1 번 선택시
      수정할 전화번호 : ________
      성공적으로 수정하였습니다.
   2 번 선택시
      수정할 주소 : _______
      성공적으로 주소를 변경하였습니다.
   0 번 선택시
      홍길동 님의 정보 수정을 취소합니다.

4 번 선택시

홍길동님의 정보를 정말로 삭제 하시겠습니까? (y/n) : ____

y 선택시 : 정보삭제
n 선택시 : 취소 초기 메뉴

5 번 선택 시
홍길동:30:010:율도국
사오정:40:016:호수
저팔계:50:019:우리
- 위 예시 처럼 전체 목록 출력

0 번 선택시
정말로 프로그램을 종료 하시겠습니까? (y/n) : ____

y 선택시 : 프로그램 종료
n 선택시 : 취소하고 초기메뉴
*/

class Customer {
	private String name;
	private int age;
	private String phoneNumber;
	private String address;

	public Customer() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}

public class CustomerManagementSystem {

	static final boolean DEBUG = false;
	
	public CustomerManagementSystem() {
	}

	public static Customer searchCustomer(LinkedList<Customer> customersList, String name) {

		Customer tempCustomer, searchCustomer = null;
		ListIterator<Customer> it = customersList.listIterator();

		while (it.hasNext()) {
			tempCustomer = it.next();
			if (name.equals(tempCustomer.getName())) {
				searchCustomer = tempCustomer;
			}
		}

		return searchCustomer;
	}

	public static StringBuffer reformPhoneNumber(StringBuffer sb) {

		StringTokenizer st = new StringTokenizer(sb.toString(), " -");
		sb.delete(0, sb.length());

		while (st.hasMoreTokens()) {
			sb.append(st.nextToken());
		}

		return sb;
	}

	public static boolean isPhoneNumberRight(String phoneNumber) {

		for (int i = 0; i < phoneNumber.length(); i++) {
			if (phoneNumber.charAt(i) < 0 || phoneNumber.charAt(i) > '9') {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Customer> customersList = new LinkedList<Customer>();

		System.out.println("고객 관리 시스템 (Customer Management System)");

		cmsOutter: while (true) {
			System.out.println("==================");
			System.out.println("1. 고객 등록");
			System.out.println("2. 고객 검색");
			System.out.println("3. 고객 정보 수정");
			System.out.println("4. 고객 정보 삭제");
			System.out.println("5. 고객 목록 보기");
			System.out.println("0. 프로그램 종료");
			System.out.println("===================");

			int index;
			while (true) {
				try {
					System.out.print("메뉴 선택: ");
					index = Integer.parseInt(br.readLine());
				} catch (NumberFormatException e) {
					System.out.println("한자리 숫자를 입력하세요.");
					continue;
				}

				if (index < 0 || index > 5) {
					System.out.println("0 ~ 5 사이의 숫자를 입력하세요.");
					continue;
				}
				break;
			}

			System.out.println();

			switching: switch (index) {

			case 0: // 프로그램 종료
				System.out.print("정말로 종료하시겠습니까? (y/n): ");

				decideExit: while (true) {
					String yesOrNo = br.readLine();

					if (yesOrNo.length() > 1) {
						System.out.print("한 글자만 입력 (y/n): ");
						continue decideExit;
					}

					char c = yesOrNo.charAt(0);

					if (c == 'y' || c == 'Y') {
						System.out.println("프로그램을 종료합니다.");
						break cmsOutter;
					} else if (c == 'n' || c == 'N') {
						System.out.println();
						break switching;
					} else {
						System.out.print("y/n 입력: ");
						continue decideExit;
					}

				}

			case 1: // 고객 등록
				Customer customer = new Customer();

				System.out.println("----- 고객 등록 -----");

				System.out.print("이름: ");
				customer.setName(br.readLine());

				setAge: while (true) {
					try {
						System.out.print("나이: ");
						customer.setAge(Integer.parseInt(br.readLine()));
						break setAge;
					} catch (NumberFormatException e) {
						System.out.println("숫자만 입력하세요.");
						continue setAge;
					}
				}

				StringBuffer sbPhoneNumber = new StringBuffer();
				String registerPhoneNumber;
				setPhoneNumber: while (true) {
					System.out.print("휴대폰 번호: ");
					sbPhoneNumber.append(br.readLine());
					registerPhoneNumber = reformPhoneNumber(sbPhoneNumber).toString();
					if (isPhoneNumberRight(registerPhoneNumber)) {
						break setPhoneNumber;
					} else {
						System.out.println("휴대폰 번호 형식이 아닙니다. 다시 입력하세요.");
						sbPhoneNumber.delete(0, sbPhoneNumber.length());
						continue setPhoneNumber;
					}
				}
				customer.setPhoneNumber(registerPhoneNumber);

				if (DEBUG) {
					System.out.println("등록된 전화번호: " + customer.getPhoneNumber());
				}

				System.out.print("자택/직장 주소: ");
				customer.setAddress(br.readLine());

				customersList.add(customer);

				System.out.println("---------------------");
				System.out.println();

				break switching;

			case 2: // 고객 검색
				System.out.println("----- 고객 검색 -----");
				System.out.print("검색할 고객 이름: ");
				String searchName = br.readLine();
				Customer searchCustomer = searchCustomer(customersList, searchName);

				System.out.println();
				if (searchCustomer != null) {

					System.out.println(searchName + "님 검색 성공");
					System.out.print("고객 정보를 열람하시겠습니까? (y/n): ");
					browse: while (true) {
						String yesOrNo = br.readLine();

						if (yesOrNo.length() > 1) {
							System.out.print("한 글자만 입력 (y/n): ");
							continue browse;
						}

						char c = yesOrNo.charAt(0);

						if (c == 'y' || c == 'Y') {
							System.out.println();
							System.out.println("----- 고객 정보 -----");
							System.out.println("이름: " + searchCustomer.getName());
							System.out.println("나이: " + searchCustomer.getAge());
							System.out.println("전화번호: " + searchCustomer.getPhoneNumber());
							System.out.println("주소: " + searchCustomer.getAddress());
							System.out.println("---------------------");
							break browse;
						} else if (c == 'n' || c == 'N') {
							System.out.println("(고객 정보 가려짐)");
							break browse;
						} else {
							System.out.print("y/n 입력: ");
							continue browse;
						}
					}
				} else {
					System.out.println(searchName + "님은 존재하지 않습니다.");
				}

				System.out.println();
				System.out.println("---------------------");
				System.out.println();

				break switching;

			case 3: // 고객 정보 수정
				System.out.println("--- 고객 정보 수정 ---");
				System.out.print("수정할 고객 이름: ");
				String changeName = br.readLine();
				Customer changeCustomer = searchCustomer(customersList, changeName);

				System.out.println();
				if (changeCustomer != null) {
					changeAge: while (true) {
						System.out.print("나이 수정: ");
						try {
							changeCustomer.setAge(Integer.parseInt(br.readLine()));
						} catch (NumberFormatException e) {
							System.out.println("숫자만 입력하세요.");
							continue changeAge;
						}
						break changeAge;
					}
					StringBuffer sbChangePhoneNumber = new StringBuffer();
					String changePhoneNumber;
					changePhoneNumber: while (true) {
						System.out.print("휴대폰 번호 수정: ");
						sbChangePhoneNumber.append(br.readLine());
						changePhoneNumber = reformPhoneNumber(sbChangePhoneNumber).toString();
						if (isPhoneNumberRight(changePhoneNumber)) {
							break changePhoneNumber;
						} else {
							System.out.println("휴대폰 번호 형식이 아닙니다. 다시 입력하세요.");
							sbChangePhoneNumber.delete(0, sbChangePhoneNumber.length());
							continue changePhoneNumber;
						}
					}
					changeCustomer.setPhoneNumber(changePhoneNumber);

					if (DEBUG) {
						System.out.println("수정된 전화번호: " + changeCustomer.getPhoneNumber());
					}

					System.out.print("주소 수정: ");
					String changeAddress = br.readLine();
					changeCustomer.setAddress(changeAddress);
				} else {
					System.out.println(changeName + "님이 존재하지 않습니다.");
				}

				System.out.println("----------------------");
				System.out.println();

				break switching;

			case 4:
				System.out.println("--- 고객 정보 삭제 ---");
				System.out.print("삭제할 고객 이름: ");
				String deleteName = br.readLine();
				Customer deleteCustomer = searchCustomer(customersList, deleteName);

				if (deleteCustomer != null) {
					System.out.print(deleteName + "님 검색 완료. 삭제하시겠습니까? (y/n): ");
					delete: while (true) {
						String yesOrNo = br.readLine();

						if (yesOrNo.length() > 1) {
							System.out.print("한 글자만 입력 (y/n): ");
							continue delete;
						}

						char c = yesOrNo.charAt(0);

						if (c == 'y' || c == 'Y') {
							customersList.remove(deleteCustomer);
							System.out.println(deleteName + "님의 정보가 삭제되었습니다.");
							break delete;
						} else if (c == 'n' || c == 'N') {
							System.out.println(deleteName + "님의 정보를 유지합니다.");
							break delete;
						} else {
							System.out.print("y/n 입력: ");
							continue delete;
						}
					}
				} else {
					System.out.println(deleteName + "님이 존재하지 않습니다.");
				}

				System.out.println("----------------------");
				System.out.println();

				break switching;

			case 5: // 고객 목록 보기
				System.out.println("----- 고객 목록 -----");
				for (Customer c : customersList) {
					System.out.println(c.getName());
				}
				System.out.println("---------------------");
				System.out.println();

				break switching;

			default:
				break switching;
			}
		}

		br.close();
	}

}
