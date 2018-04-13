#### mybatis generator使用方法
1. 添加maven依赖

    <dependencies>
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
        </dependency>
    </dependencies>
    
    
2. 添加generator插件

       <build>
           <plugins>
               <plugin>
                   <groupId>org.mybatis.generator</groupId>
                   <artifactId>mybatis-generator-maven-plugin</artifactId>
                   <version>1.3.3</version>
                   <configuration>
                       <configurationFile>${project.basedir}/src/main/resources/generatorConfig.xml</configurationFile>
                   </configuration>
               </plugin>
           </plugins>
       </build>

3. 添加generator配置文件
generator配置文件详情见${project.basedir}/src/main/resources/generatorConfig.xml

4. mybatis generator插件官方网站

5. 运行方法
 ”Maven Projects"-> 点击模块“mybatis_generator"下的Plugins -> 查看到多了一个mybatis-generator的插件，运行”mybatis-generator：generaotr"即可。
  
   