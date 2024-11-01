به نام خدا

# آشنایی با اصول شئ‌گرایی (موسوم به اصول SOLID)

### افزودن یک روش پیام رسانی دیگر

	تغییراتی را که در کد فعلی برنامه می‌دهید، در جدول زیر ثبت کنید و در نهایت تعداد کل تغییرات را اعلان کنید.
    - توجه: مواردی که به عنوان تغییرات باید اعلان شود شامل این موارد هستند:
      1. ساخت کلاس جدید
      2. افزودن تابع جدید به کلاس و یا واسط (برای توابع جدید صرفا اعلام تغییر کنید)
      3. هر خطوط پیاپی‌ای که در تابع main و برای افزودن یک قابلیت جدید اضافه می‌کنید. به عنوان مثال اگر سه خط را به منظور تشخیص نوع پیام اضافه می‌کنید، آن سه خط را در قالب یک تغییر اعلام کنید (البته جزییات آن را در ستون «شرحی کوتاه از تغییر» توضیح دهید).

<table dir='rtl'>
<tbody>
<tr>
<td width="64">
<p><strong>ردیف</strong></p>
</td>
<td width="198">
<p><strong>محل اعمال تغییرات (کلاس/واسط)</strong></p>
</td>
<td width="141">
<p><strong>عنوان تغییر</strong></p>
</td>
<td width="292">
<p><strong>شرحی کوتاه از تغییر</strong></p>
</td>
</tr>
<tr>
<td width="64">
<p><strong>۱</strong></p>
</td>
<td width="198">
<p>MessageService</p>
</td>
<td width="141">
<p>افزودن تابع ارسال پیام تلگرامی</p>
</td>
<td width="292">
<p>افزودن یک تابع void با عنوان sendTelegramMessage</p>
</td>
</tr>

<tr>
<td width="64">
<p><strong>۲</strong></p>
</td>
<td width="198">
<p>TelegramMessage</p>
</td>
<td width="141">
<p>افزودن کلاس پیام تلگرام</p>
</td>
<td width="292">
<p>با فیلدهای آی دی و شماره موبایل برای source و target</p>
</td>
</tr>


<tr>
<td width="64">
<p><strong>۳</strong></p>
</td>
<td width="198">
<p>TelegramMessageService</p>
</td>
<td width="141">
<p>افزودن کلاس سرویس پیام تلگرام</p>
</td>
<td width="292">
<p>ارث بری از واسط MessageService و پیاده سازی متودهای آن</p>
</td>
</tr>


<tr>
<td width="64">
<p><strong>۴</strong></p>
</td>
<td width="198">
<p>EmailMessageService و SmsMessageService </p>
</td>
<td width="141">
<p>افزودن متود sendTelegramMessage</p>
</td>
<td width="292">
<p>پیاده سازی متود جدید با empty body</p>
</td>
</tr>

<tr>
<td width="64">
<p><strong>۵</strong></p>
</td>
<td width="198">
<p>TelegramMessageService</p>
</td>
<td width="141">
<p>افزودن متود sendTelegramMessage و validateTelegramId و validatePhoneNumber</p>
</td>
<td width="292">
<p>پیاده سازی متودهای صحت سنجی شماره موبایل و آی دی و استفاده در عملیات ارسال پیام تلگرام</p>
</td>
</tr>

<tr>
<td width="64">
<p><strong>۶</strong></p>
</td>
<td width="198">
<p>Main</p>
</td>
<td width="141">
<p>اضافه کردن گزینه ارسال پیام تلگرام</p>
</td>
<td width="292">
<p>پیاده سازی کیس جدید برای دریافت شماره موبایل یا آی دی تلگرام برای ارسال پیام</p>
</td>
</tr>

<tr>
<td width="64">
<p><strong>۷</strong></p>
</td>
<td width="198">
<p>Main</p>
</td>
<td width="141">
<p>اضافه کردن بررسی کلاس TelegramMessageService</p>
</td>
<td width="292">
<p>بررسی با instanceof</p>
</td>
</tr>
</tbody>
</table>

مجموع تعداد تغییرات: ۷

###  تحلیل و وارسی برنامه از منظر تحقق و یا عدم تحقق اصول SOLID
در خصوص این برنامه‌ای که نوشته شده بود و شما یک قابلیت به آن اضافه کردید، بر اساس اصول SOLID موارد نقض و یا محقق شدن هر کدام از آن اصول را بیان کنید. در بیان موارد تحقق و نقض، علت تحقق و یا نقض را نیز به صورت کامل توضیح دهید:

<table dir='rtl'>
<tbody>
<tr>
<td rowspan="2" width="240">
<p>اصل 1</p>
<p>Single Responsibility</p>
</td>
<td width="95">
<p><strong>موارد تحقق</strong></p>
</td>
<td width="454">
در موارد مدل های Message، هرکدام از مدل ها روی اطلاعات مسیج و ویژگی های مختص هر مدل تمرکز کرده و از این نظر این اصل را رعایت کرده است.
<p>&nbsp;</p>
در قسمت سرویس ها، هر سرویس روی فرستادن و پردازش تایپ مسیج خودش تمرکز کرده.
</td>
</tr>
<tr>
<td>
<p><strong>موارد نقض</strong></p>
</td>
<td>
سرویس Message همه ی دیگر سرویس ها را ملزم میکند تا نوع مسیج های دیگری که به آنها مربوط نیستند هم پیاده سازی کنند و به همین علت در سرویس ها شاهد توابع خالی و بدون استفاده هستیم که نشانگر این است که این اصل نقض شده است
<p>&nbsp;</p>
</td>
</tr>
<tr>
<td rowspan="2">
<p>اصل 2</p>
<p>Open-Close Principle (OCP)</p>
</td>
<td>
<p><strong>موارد تحقق</strong></p>
</td>
<td>
برای طراحی مدل ها، همگی کلاس Message را extend میکنند که این امر باعث میشود بدون تغییری در کلاس Message، یک نوع مسیج دیگر اضافه شود
<p>&nbsp;</p>
</td>
</tr>
<tr>
<td>
<p><strong>موارد نقض</strong></p>
</td>
<td>
اینترفیس MessageService به خوبی طراحی نشده و اگر یک نوع مسیج دیگر اضافه کنیم، مجبور میشویم که این اینترفیس را نیز تغییر دهیم که باعث نقض اصل OCP میشود
<p>&nbsp;</p>
همچنین با اضافه کردن یک نوع مسیج دیگر، کلاس های سرویس هم باید تغییر کنند
</td>
</tr>
<tr>
<td rowspan="2">
<p>اصل 3</p>
<p>Liskov Substitution Principle</p>
</td>
<td>
<p><strong>موارد تحقق</strong></p>
</td>
<td>
برای کلاس Message و سابکلاس های آن، به خوبی و به درستی همه ی ویژگی های آن به زیرکلاس ها اعمال میشود و همگی میتوانند از آن ویژگی ها استفاده کنند
<p>&nbsp;</p>
</td>
</tr>
<tr>
<td>
<p><strong>موارد نقض</strong></p>
</td>
<td>
در پیاده سازی MessageServiceها، این اصل نقض شده. زیرا با جابجایی یک Service با سرویس دیگر، متدهای خالی میتوانند باعث ایجاد خطا شوند
<p>&nbsp;</p>
</td>
</tr>
<tr>
<td rowspan="2">
<p>اصل 4</p>
<p>Interface Segregation Principle</p>
</td>
<td>
<p><strong>موارد تحقق</strong></p>
</td>
<td>
-
<p>&nbsp;</p>
</td>
</tr>
<tr>
<td>
<p><strong>موارد نقض</strong></p>
</td>
<td>
سرویس Message همه ی دیگر سرویس ها را ملزم میکند تا نوع مسیج های دیگری که به آنها مربوط نیستند هم پیاده سازی کنند و به همین علت در سرویس ها شاهد توابع خالی و بدون استفاده هستیم که نشانگر این است که این اصل نقض شده است
<p>&nbsp;</p>
</td>
</tr>
<tr>
<td rowspan="2">
<p>اصل 5</p>
<p>Dependency Inversion Principle</p>
</td>
<td>
<p><strong>موارد تحقق</strong></p>
</td>
<td>
در سرویس ها، همه ی کلاس ها از MessageService استفاده میکنند و همگی به آن dependency دارند
<p>&nbsp;</p>
</td>
</tr>
<tr>
<td>
<p><strong>موارد نقض</strong></p>
</td>
<td>
-
<p>&nbsp;</p>
</td>
</tr>
</tbody>
</table>

در خصوص هرکدام از موارد نقض هرکدام از اصول، یک راهکار را به منظور رفع آن مشکل ارایه داده و در جدول زیر ثبت نمایید:

<table dir='rtl'>
<tbody>
<tr>
<td width="168">
<p><strong>اصل مربوطه (از اصول </strong><strong>SOLID</strong><strong>)</strong></p>
</td>
<td width="246">
<p><strong>علت نقض</strong></p>
</td>
<td width="284">
<p><strong>راه حل پیشنهادی</strong></p>
</td>
</tr>
<tr>
<td width="168">
Single Responsibility
<p>&nbsp;</p>
</td>
<td width="246">
گذاشتن توابع در اینترفیس Message که به همه مربوط نمیشود
<p>&nbsp;</p>
</td>
<td width="284">
میتوانیم اینترفیس ها را از هم جدا کنیم تا هر سرویس اینترفیس خود را پیاده سازی کنند.
میتوانیم یک تابع sendMessage کلی برای همه بذاریم و هرکس sendMessage خود را پیاده سازی کند
<p>&nbsp;</p>
</td>
</tr>
<tr>
<td width="168">
OCP
<p>&nbsp;</p>
</td>
<td width="246">
در MessageService توابع نامربوط به همه ی سرویس ها نهاده شده
<p>&nbsp;</p>
</td>
<td width="284">
اگر یک تابع برای sendMessage در نظر بگیریم، با اضافه کردن یک نوع مسیج دیگر، نیاز به تغییری در این انترفیس نخواهیم داشت
<p>&nbsp;</p>
</td>
</tr>
<tr>
<td width="168">
Liskov Substitution Principle
<p>&nbsp;</p>
</td>
<td width="246">
توابع خالی منجر به ارور مبشوند
<p>&nbsp;</p>
</td>
<td width="284">
اگر قسمت قبلی را درست کنیم، این اصل هم حل میشود
<p>&nbsp;</p>
</td>
</tr>
<tr>
<td width="168">
ISP
<p>&nbsp;</p>
</td>
<td width="246">
گذاشتن توابع در اینترفیس Message که به همه مربوط نمیشود
<p>&nbsp;</p>
</td>
<td width="284">
میتوانیم اینترفیس ها را از هم جدا کنیم تا هر سرویس اینترفیس خود را پیاده سازی کنند. میتوانیم یک تابع sendMessage کلی برای همه بذاریم و هرکس sendMessage خود را پیاده سازی کند
<p>&nbsp;</p>
</td>
</tr>
</tbody>
</table>

### پاسخ سوالات

1. موارد 1 و 4 جدول تغییرات گام اول، اگر اصول شی گرایی از ابتدا برقرار بود حذف میشد و به جای آنها صرفا پیاده سازی متد sendMessage کفایت میکرد
2. رعایت اصول شی‌ گرایی، کد را خواناتر، قابل نگهداری و توسعه‌پذیر می‌کند، به‌طوری‌ ‌که افزودن ویژگی‌ های جدید به‌ راحتی و بدون تغییرات عمده در کد موجود امکان‌ پذیر است. همچنین، کد با انعطاف‌ پذیری بیشتر و کاهش وابستگی‌ ها، بهبود تست‌ پذیری و کاهش احتمال بروز خطا را فراهم می‌کند. 
