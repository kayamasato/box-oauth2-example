# Box の OAuth2 サンプルアプリ

## 起動方法

1. OAuthController の `CLIENT_ID` と `CLIENT_SECRET` を変更してください。
2. 以下のコマンドを実行してください。

```bash
./gradlew bootRun
```

3. 起動後 `http://localhost:8080/oauth` にアクセスしてください。

以上で、OAuth2 の処理が始まります。Box にてログイン後、ログインした（権限をアプリケーションに与えた）ユーザのルートフォルダに含まれているファイル名、フォルダ名を表示します。

