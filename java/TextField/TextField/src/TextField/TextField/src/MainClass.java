import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// メインクラス
public class MainClass {	// MainClassの定義

	// Javaのエントリポイント
	public static void main(String[] args){	// mainメソッドの定義

		// フレームの生成.
		Frame frame = new Frame();	// Frameオブジェクトを生成し, frameに格納.

		// サイズのセット.
		frame.setSize(640, 480);	// setSizeでサイズを(640, 480)にセット.

		// デフォルトのレイアウトを無効にする.
		frame.setLayout(null);	// frameにセットされている既定のレイアウトをsetLayout(null)で無効にする.

		// ラベルの生成.
		Label label = new Label("label");	// "label"と表示するLabelオブジェクトを生成し, インスタンスをlabelに格納.

		// ラベルの位置とサイズをセット.
		label.setBounds(200, 150, 120, 30);	// label.setBoundsでラベルの位置を(200, 150), サイズを(120, 30)にセット.

		// ボタンの生成
		Button button = new Button("button");	// "button"と表示するButtonオブジェクトを生成し, インスタンスをbuttonに格納.

		// ボタンの位置とサイズをセット.
		button.setBounds(200, 200, 120, 80);	// button.setBoundsでボタンの位置を(200, 200), サイズを(120, 80)にセット.

		// テキストフィールドの生成.
		TextField textField = new TextField("textField");	// "textField"と表示するTextFieldオブジェクトを生成し, インスタンスをtextFieldに格納.

		// テキストフィールドの位置とサイズをセット.
		textField.setBounds(200, 300, 120, 30);	// textField.setBoundsでテキストフィールドの位置を(200, 300), サイズを(120, 30)にセット.

		// アクションリスナーをセット.
		button.addActionListener(new ActionListener(){	// button.addActionListenerでActionListenerを匿名クラスという形でセット.

			// アクションが発生した時.(ボタンが押された時.)
			public void actionPerformed(ActionEvent e){	// actionPerformedをオーバーライド.

				// ラベルにテキストフィールドのテキストをセット.
				label.setText(textField.getText());	// label.setTextでtextField.getText()で取得したテキストをセット.

			}

		});

		// フレームにラベルを配置.
		frame.add(label);	// frame.addでlabelを追加.

		// フレームにボタンを配置.
		frame.add(button);	// frame.addでbuttonを追加.

		// フレームにテキストフィールドを配置.
		frame.add(textField);	// frame.addでtextFieldを追加.

		// 表示状態のセット.
		frame.setVisible(true);	// setVisibleで表示状態をtrueにセット.

		// ウィンドウリスナーのセット.
		frame.addWindowListener(new WindowAdapter(){	// WindowAdapterを継承した匿名クラスとしてアダプタを定義し, 引数としてaddWindowListenerに渡す.

			// windowClosedとwindowClosingのみオーバーライド. それ以外はWindowAdapterに既定の動作が定義されている.
			// ウィンドウが閉じられた時.
			public void windowClosed(WindowEvent e){	// windowClosedの定義

				// アプリケーションの終了
				System.exit(0);	// System.exit(0)でアプリケーションを終了.

			}

			// ウィンドウが閉じられている時.
			public void windowClosing(WindowEvent e){	// windowClosingの定義

				// ウィンドウリソースの開放
				e.getWindow().dispose();	// e.getWindowでWindowが取得できるので, そのWindowをdisposeで破棄する.

			}

		});

	}

}