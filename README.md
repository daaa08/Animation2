# Animation

- compositeView 사용
```java
public class MyCompositeView extends FrameLayout {
    private View mView;

    public MyCompositeView(@NonNull Context context) {
        this(context,null);
    }

    public MyCompositeView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyCompositeView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mView = LayoutInflater.from(context).inflate(R.layout.item_menu,this,true);
        TypedArray ta = context.obtainStyledAttributes(attrs,R.styleable.MyCompositeView);
        int leftBtn = ta.getColor(R.styleable.MyCompositeView_left_btn,0);
        if(leftBtn != 0)
        mView.findViewById(R.id.btn).setBackgroundColor(leftBtn);
    }
}
```
- ObjectAnimator
```java
View hae = view.findViewById(R.id.sun);
                View sea = view.findViewById(R.id.sea);
                View sky = view.findViewById(R.id.sky);
                int skyColor = v.getContext().getResources().getColor(R.color.blue_sky);
                int sunsetColor = v.getContext().getResources().getColor(R.color.sunset_sky);
                int nigjtColor = v.getContext().getResources().getColor(R.color.night_sky);

                ObjectAnimator animator = ObjectAnimator
                        .ofFloat(hae,"y",hae.getTop(),sea.getTop())
                        .setDuration(6000);
                        
                ObjectAnimator colorAnimator = ObjectAnimator
                        .ofInt(sky,"backgroundColor",skyColor,sunsetColor)
                        .setDuration(6000);
                colorAnimator.setEvaluator(new ArgbEvaluator());
                colorAnimator.setInterpolator(new AccelerateInterpolator()); // 가속

                ObjectAnimator nightColorAnimator = ObjectAnimator
                        .ofInt(sky,"backgroundColor",sunsetColor,nigjtColor)
                        .setDuration(3000);
                nightColorAnimator.setEvaluator(new ArgbEvaluator());
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(animator).with(colorAnimator).before(nightColorAnimator);
                animatorSet.start();
            }
```
- onMeasure
```java
 @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // 정의해줘야 쓸 수 있음
        int width = getDefaultSize(getSuggestedMinimumWidth(),widthMeasureSpec);
        int height = getDefaultSize(getSuggestedMinimumHeight(),heightMeasureSpec);
        if(width > height){
            width = height;
        }else{
            height = width;
        }
        setMeasuredDimension(width,height);
    }
```
> setWidth(getHeight());  // width의 길이는 height의 길이를 가져옴 -> 정사각형 만들기
