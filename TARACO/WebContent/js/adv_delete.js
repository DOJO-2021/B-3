'use strict';
function check(){
 if(window.confirm('\n《確認》\n削除ボタンが押されました。\n本当にこのアドバイスを削除してもよろしいですか？')){
  return true;
 }
 else{
 window.alert('\n キャンセルされました。'); // 警告ダイアログを表示
		return false;
 }
}