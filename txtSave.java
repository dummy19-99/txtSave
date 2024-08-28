import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class txtSave {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String filePath = "C:/CODE/JAVA/txtSave.txt"; // 파일 경로 설정
        
        try (FileWriter fw = new FileWriter(filePath, true)) { // 파일에 내용 추가 모드
            System.out.println("텍스트를 입력하세요. (저장을 중지하려면 'exit' 입력):");
            
            while (true) {
                String content = sc.nextLine(); // 사용자 입력받기
                if (content.equalsIgnoreCase("exit")) { // 'exit' 입력 시 종료
                    break;
                }
                fw.write(content + "\n"); // 입력된 내용 파일에 쓰기
            }
            System.out.println("텍스트가 파일에 저장되었습니다.");
        } catch (IOException e) {
            System.err.println("파일 저장 중 오류 발생: " + e.getMessage());
        }

        // 파일 읽기 부분
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int num = 1;
            System.out.println("\n저장된 내용:");
            while ((line = br.readLine()) != null) { // 파일에서 한 줄씩 읽기
                System.out.println(num + ". " + line);
                num++;
            }
        } catch (IOException e) {
            System.err.println("파일 읽기 중 오류 발생: " + e.getMessage());
        }
    }
}
