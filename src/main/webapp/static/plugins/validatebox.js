//easyUI����֤  
/* ��֤ */
$.extend($.fn.validatebox.defaults.rules,
    {
        //������֤
        equals : {
            validator : function(value, param) {
                return value == $(param[0]).val();
            },
            message : '�������벻һ��.'
        },
        // �ƶ��ֻ�������֤
        mobile : {// valueֵΪ�ı����е�ֵ
            validator : function(value) {
                var reg = /^1[3|4|5|8|9]\d{9}$/;
                return reg.test(value);
            },
            message : '�����ֻ������ʽ��׼ȷ.'
        },
        combo : {
            validator : function(value) {
                if (value) {
                    return true;
                } else {
                    return false;
                }
            },
            message : '����Ϊ��'
        },
        // ��֤�绰����
        phone : {
            validator : function(value) {
                return /^((\d2,3)|(\d{3}\-))?(0\d2,3|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/i
                    .test(value);
            },
            message : '��ʽ����ȷ,��ʹ�������ʽ:020-88888888'
        },
        // �绰������ֻ�����
        phoneAndMobile : {
            validator : function(value) {
                return /^((\d2,3)|(\d{3}\-))?(0\d2,3|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/i
                        .test(value)
                    || /^(13|15|18)\d{9}$/i.test(value);
            },
            message : '�绰������ֻ������ʽ����ȷ'
        },
        // ��֤������С��
        intOrFloat : {
            validator : function(value) {
                return /^\d+(\.\d+)?$/i.test(value);
            },
            message : '���������֣���ȷ����ʽ��ȷ'
        },
        // ��֤����
        integer : {
            validator : function(value) {
                return /^[+]?[1-9]+\d*$/i.test(value);
            },
            message : '����������'
        },
        // ��֤�Ƿ�����ո�ͷǷ��ַ�
        unnormal : {
            validator : function(value) {
                return /.+/i.test(value);
            },
            message : '����ֵ����Ϊ�պͰ��������Ƿ��ַ�'
        },
        //��֤���ƺ���
        carNo : {
            validator : function(value) {
                return /^[\u4E00-\u9FA5][\da-zA-Z]{6}$/.test(value);
            },
            message : '���ƺ�����Ч��������B12350��'
        },
        // �û�������֤(ֻ�ܰ��� _ ���� ��ĸ)
        account : {// param��ֵΪ[]��ֵ
            validator : function(value, param) {
                if (value.length < param[0]
                    || value.length > param[1]) {
                    $.fn.validatebox.defaults.rules.account.message = '���ȱ�����'
                        + param[0] + '��' + param[1] + '��Χ';
                    return false;
                } else {
                    if (!/(?=.*?[a-zA-Z])(?=.*?[0-9])[a-zA-Z0-9]{8,}$/
                            .test(value)) {
                        $.fn.validatebox.defaults.rules.account.message = '����������ֺ���ĸ.';
                        return false;
                    } else {
                        return true;
                    }
                }
            },
            message : 'ֻ�����֡���ĸ���»������'
        },
        // �û��˺���֤(ֻ�ܰ��� _ ���� ��ĸ)
        username : {
            validator : function(value) {
                return /^[a-zA-Z][a-zA-Z0-9_]{5,15}$/i.test(value);
            },
            message : '�û������Ϸ�����ĸ��ͷ������6-16�ַ���������ĸ�����»��ߣ�'
        },
        // ������֤
        CHS : {
            validator : function(value) {
                return /^[\u0391-\uFFE5]+$/.test(value);
            },
            message : 'ֻ�����뺺��'
        },
        //������֤
        equals: {
            validator: function(value,param){
                return value == $(param[0]).val();
            },
            message: 'Field do not match.'
        },
        // ��֤���֤
        idcard : {
            validator : function(num) {
                num = num.toUpperCase();
                //���֤����Ϊ15λ����18λ��15λʱȫΪ���֣�18λǰ17λΪ���֣����һλ��У��λ������Ϊ���ֻ��ַ�X��
                if (!(/(^\d{15}$)|(^\d{17}([0-9]|X)$)/.test(num))) {
                    return false;
                }
                //У��λ����ISO 7064:1983.MOD 11-2�Ĺ涨���ɣ�X������Ϊ������10��
                //����ֱ�����������ں�У��λ
                var len, re;
                len = num.length;
                if (len == 15) {
                    re = new RegExp(
                        /^(\d{6})(\d{2})(\d{2})(\d{2})(\d{3})$/);
                    var arrSplit = num.match(re);

                    //������������Ƿ���ȷ
                    var dtmBirth = new Date('19' + arrSplit[2]
                        + '/' + arrSplit[3] + '/' + arrSplit[4]);
                    var bGoodDay;
                    bGoodDay = (dtmBirth.getYear() == Number(arrSplit[2]))
                        && ((dtmBirth.getMonth() + 1) == Number(arrSplit[3]))
                        && (dtmBirth.getDate() == Number(arrSplit[4]));
                    if (!bGoodDay) {
                        return false;
                    } else {
                        //��15λ���֤ת��18λ
                        //У��λ����ISO 7064:1983.MOD 11-2�Ĺ涨���ɣ�X������Ϊ������10��
                        var arrInt = new Array(7, 9, 10, 5, 8, 4,
                            2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2);
                        var arrCh = new Array('1', '0', 'X', '9',
                            '8', '7', '6', '5', '4', '3', '2');
                        var nTemp = 0, i;
                        num = num.substr(0, 6) + '19'
                            + num.substr(6, num.length - 6);
                        for (i = 0; i < 17; i++) {
                            nTemp += num.substr(i, 1) * arrInt[i];
                        }
                        num += arrCh[nTemp % 11];
                        return true;
                    }
                }
                if (len == 18) {
                    re = new RegExp(
                        /^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X)$/);
                    var arrSplit = num.match(re);

                    //������������Ƿ���ȷ
                    var dtmBirth = new Date(arrSplit[2] + "/"
                        + arrSplit[3] + "/" + arrSplit[4]);
                    var bGoodDay;
                    bGoodDay = (dtmBirth.getFullYear() == Number(arrSplit[2]))
                        && ((dtmBirth.getMonth() + 1) == Number(arrSplit[3]))
                        && (dtmBirth.getDate() == Number(arrSplit[4]));
                    if (!bGoodDay) {
                        return false;
                    } else {
                        //����18λ���֤��У�����Ƿ���ȷ��
                        //У��λ����ISO 7064:1983.MOD 11-2�Ĺ涨���ɣ�X������Ϊ������10��
                        var valnum;
                        var arrInt = new Array(7, 9, 10, 5, 8, 4,
                            2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2);
                        var arrCh = new Array('1', '0', 'X', '9',
                            '8', '7', '6', '5', '4', '3', '2');
                        var nTemp = 0, i;
                        for (i = 0; i < 17; i++) {
                            nTemp += num.substr(i, 1) * arrInt[i];
                        }
                        valnum = arrCh[nTemp % 11];
                        if (valnum != num.substr(17, 1)) {
                            return false;
                        }
                        return true;
                    }
                }
                return false;
            },
            message : '���֤�����ʽ����ȷ'
        },
    });