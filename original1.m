function newlattice=original1(new_lattice)





%letter A,B,C/ By changing lattice, we can obtain various 
lattice_A=[-1,-1,-1,-1,1,1,-1,-1,-1,-1;-1,-1,-1,1,1,1,1,-1,-1,-1;-1,-1,1,1,-1,-1,1,1,-1,-1;-1,1,1,-1,-1,-1,-1,1,1,-1;-1,1,1,1,1,1,1,1,1,-1;1,1,1,1,1,1,1,1,1,1;1,1,1,-1,-1,-1,-1,1,1,1;1,1,-1,-1,-1,-1,-1,-1,1,1;1,1,-1,-1,-1,-1,-1,-1,1,1;1,1,-1,-1,-1,-1,-1,-1,1,1];
lattice_B=[1,1,1,1,1,-1,-1,-1,-1,-1;1,1,-1,-1,1,1,-1,-1,-1,-1;1,1,-1,-1,1,1,-1,-1,-1,-1;1,1,-1,-1,1,1,-1,-1,-1,-1;1,1,1,1,1,-1,-1,-1,-1,-1;1,1,1,1,1,-1,-1,-1,-1,-1;1,1,-1,-1,1,1,-1,-1,-1,-1;1,1,-1,-1,1,1,-1,-1,-1,-1;1,1,-1,-1,1,1,-1,-1,-1,-1;1,1,1,1,1,-1,-1,-1,-1,-1];
lattice_C=[-1,1,1,1,1,1,1,-1,-1,-1;1,1,1,1,1,1,1,-1,-1,-1;1,1,1,-1,-1,-1,-1,-1,-1,-1;1,1,-1,-1,-1,-1,-1,-1,-1,-1;1,1,-1,-1,-1,-1,-1,-1,-1,-1;1,1,-1,-1,-1,-1,-1,-1,-1,-1;1,1,1,-1,-1,-1,-1,-1,-1,-1;1,1,1,-1,-1,-1,-1,-1,-1,-1;1,1,1,1,1,1,1,-1,-1,-1;-1,1,1,1,1,1,1,-1,-1,-1];
m=1; %the number of configuration of neural network
N=1;


energy(1)=0;
%calculate initial energy
for i=1:10
    for j=1:10
        if i==10&&j==10
            break;
        end
        if j<10
            for k=j+1:10
            
            energy(1)=energy(1)-lattice_A(i,j)^2*lattice_A(i,k)^2;
            end
        end
        for s=i+1:10
            for p=1:10
                energy(1)=energy(1)-lattice_A(i,j)^2*lattice_A(s,p)^2;
            end
        end
    end
end


 for x_axis=1:10
    for y_axis=1:10
    
    Ener_con=new_lattice(:,:,N);
    Ener_con(x_axis,y_axis)=-Ener_con(x_axis,y_axis);
    
    m=m+1;
    energy_old=0;
    energy_new=0;
    %calcuate old energy before fliping
    for I=1:10
    for J=1:10
        if I==10&&J==10
            break;
        end
        if J<10
            for K=J+1:10
            rand_n=rand(1);
            if rand_n>0.5
            energy_old=energy_old-new_lattice(I,J,N)*new_lattice(I,K,N)*lattice_A(I,J)*lattice_A(I,K);
            end
            end
        end
    
        for s=I+1:10
            for p=1:10
                rand_n=rand(1);
                if rand_n>0.5
                energy_old=energy_old-new_lattice(I,J,N)*new_lattice(s,p,N)*lattice_A(I,J)*lattice_A(s,p);
                end
            end
        end
        
    end
    end
    
    % calculate new energy after fliping
    for I=1:10
    for J=1:10
        if I==10&&J==10
            break;
        end
        if J<10
            for K=J+1:10
            rand_n=rand(1);
            if rand_n>0.5  
            energy_new=energy_new-Ener_con(I,J)*Ener_con(I,K)*lattice_A(I,J)*lattice_A(I,K);
            end
            end
        end
        for s=I+1:10
            for p=1:10
                rand_n=rand(1);
            if rand_n>0.5
                energy_new=energy_new-Ener_con(I,J)*Ener_con(s,p)*lattice_A(I,J)*lattice_A(s,p);
            end
            end
        end
    end
    end
    
    %compare two energy or calculate fliping energy
    if energy_new-energy_old<0
        new_lattice(:,:,N+1)=Ener_con(:,:);
        N=N+1;
        energy(N)=energy_new;
    end
    end
end


newlattice=new_lattice(:,:,N);
