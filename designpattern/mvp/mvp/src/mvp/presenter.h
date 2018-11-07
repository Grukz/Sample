// 二重インクルード防止
#ifndef __PRESENTER_H_
#define __PRESENTER_H_

// 独自のヘッダ
#include "subject.h" // interface_subject
#include "observer.h" // interface_observer
#include "view.h" // class_view

// クラスclass_presenter
class class_presenter : public interface_observer{

  // 非公開メンバ
  private:

    // 非公開メンバ関数
    interface_subject *subject_; // interface_subjectポインタsubject_.

  // 公開メンバ
  public:

    // 公開メンバ関数
    // コンストラクタとデストラクタ
    class_presenter(){}; // コンストラクタclass_presenter
    virtual ~class_presenter(){}; // デストラクタ~class_presenter
    // メンバ関数
    virtual void set_subject(interface_subject *subject); // メンバ関数set_subject
    virtual void changed(); // メンバ関数changed
    void set_view(class_view *view); // メンバ関数set_view

};

#endif
