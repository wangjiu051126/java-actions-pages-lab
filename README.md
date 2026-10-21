# Java Actions & Pages Lab

基于 **Java + Maven** 的 GitHub Actions 自动化测试与 GitHub Pages 部署实验（Python 版实验的 Java 进阶改造）。

## 工程结构

```
java-actions-pages-lab/
├── pom.xml                      # Maven 工程配置（含 JUnit5 / JaCoCo / exec 插件）
├── .github/
│   ├── workflows/
│   │   ├── ci.yml               # 矩阵 CI：多 OS × 多 JDK + 缓存 + 覆盖率
│   │   └── deploy.yml           # 生成静态站点并部署到 GitHub Pages
│   └── dependabot.yml           # 自动依赖更新（拓展项）
└── src/
    ├── main/java/com/example/lab/
    │   ├── Calculator.java      # 核心逻辑（含异常处理与 factorial）
    │   └── SiteGenerator.java   # 静态站点生成器（替代 MkDocs）
    └── test/java/com/example/lab/
        └── CalculatorTest.java  # JUnit 5 测试（参数化 + 异常测试）
```

## 本地验证

```bash
mvn -B verify                 # 编译 + 测试 + 覆盖率
mvn -B exec:java -Dexec.args="target/site"   # 生成站点到 target/site
```

详细步骤见 **实验操作指南.md**。
