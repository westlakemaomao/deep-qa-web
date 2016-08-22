import java.util.List;

import org.apdplat.qa.SharedQuestionAnsweringSystem;
import org.apdplat.qa.model.CandidateAnswer;
import org.apdplat.qa.model.Question;

/**
 * @author hzyuyongmao
 * @version 创建时间：2016年8月22日 下午5:47:39 类说明
 */

public class QaTest {
	public static void main(String[] args) {
		String questionStr = "老聃科技的创始人是谁";
		// Scanner scanner = new Scanner(System.in);
		// while(scanner.hasNext()){
		// String questionStr = scanner.nextLine();

		// 系统默认
		// Question question =
		// SharedQuestionAnsweringSystem.getInstance().answerQuestion(questionStr);
		// 模型初始化时自定义数据源
		Question question = SharedQuestionAnsweringSystem.getInstanceByDataSourceType("userid").answerQuestion(questionStr);

		// question.addCandidateQuestionType(QuestionType.NUMBER);
		if (question != null) {
			System.out.println("answer!!");
			List<CandidateAnswer> candidateAnswers = question.getAllCandidateAnswer();
			int i = 1;
			for (CandidateAnswer candidateAnswer : candidateAnswers) {
				System.out.println((i++) + "、" + candidateAnswer.getAnswer() + ":" + candidateAnswer.getScore());
			}
		}
	}
}
