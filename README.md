# rina-hagihara-GroupReportSystem_SpringBoot

このアプリケーションは引っ越し業者が行う一連のプロセス(アポイント獲得、受注、引っ越し作業、決済)を
チームで共有し、効率化するものです。


## デモ
#### デモ画面
![GroupReportSystem_demo](https://user-images.githubusercontent.com/105138680/201002542-bfde4a64-399e-4660-9076-d407bda773f0.png)


#### ER図
![ER図](https://user-images.githubusercontent.com/105138680/201304608-30e65ff3-dc8b-4407-b37b-de9346affbb6.png)


#### ワイヤーフレーム
![ワイヤーフレーム](https://user-images.githubusercontent.com/105138680/201299984-44941e3f-697d-4991-956c-a8133d0ffb78.png)


## 使い方

1.「従業員一覧」→「新規従業員登録画面」から従業員を登録します。(管理権限を持っているユーザーのみ)
　　1.アポイントを獲得した時点で「案件一覧」→「新規案件登録画面」から案件を登録します。この時同時に「顧客一覧」→「顧客新規作成画面」から顧客を作成し、
先ほど作成した案件の「詳細画面」から顧客を追加します。
.プロセスが進むごとに案件内にある「新規日報登録画面」から日報を作成し、情報を共有します。
4.担当従業員が決まった時点で「案件一覧」→「案件詳細画面」から担当者をアサインします。
5.トップ画面ではログインしている従業員の担当してる案件を見ることができます。



## 環境

* SpringBoot
* Thymeleaf



## 文責

* Rina Hagihara
* rina_hagihara@shiten.page



## ライセンス

"rina-hagihara-GroupReportSystem_SpringBoo" is under [Rina Hagihara](#).



