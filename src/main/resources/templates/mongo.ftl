<html lang="zh-CN">
<head>
    <meta charset="UTF-8"/>
    <title>${title}</title>
    <style>
        table {
            width: 100%;
            font-size: .938em;
            border-collapse: collapse;/*边框合并*/
        }
        th {
            text-align: left;
            padding: .5em .5em;
            font-weight: bold;
            background: #66677c;color: #fff;
        }

        td {
            padding: .5em .5em;
            border-bottom: solid 1px #ccc;
        }

        table,table tr th, table tr td { border:1px solid #0094ff; }/*设置边框*/
    </style>
</head>
<body>
<table>
    <tr>
        <th>level</th>
        <th>logger</th>
        <th>thread</th>
        <th>message</th>
        <th>timestamp</th>
    </tr>
        <#list mongoEntities as mongoEntity>
            <tr>
                <td>${mongoEntity.level}</td>
                <td>${mongoEntity.logger}</td>
                <td>${mongoEntity.thread}</td>
                <td>${mongoEntity.message}</td>
                <td>${mongoEntity.timestamp}</td>
            </tr>
        </#list>
</table>
</body>
</html>
