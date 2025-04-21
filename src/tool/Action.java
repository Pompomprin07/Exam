// すべてのアクションクラスのスーパークラス
// 抽象クラス、抽象メソッドとしてそれぞれ定義
	// 抽象クラス : 完成していないクラス(中身がない)
	// 使用する場合は、「継承」が必要

package tool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Action {
	// メソッド名 : execute
    public abstract void execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
